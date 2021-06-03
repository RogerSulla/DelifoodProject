package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.model.Direccion;
import pe.edu.upc.service.IDireccionService;

@Controller
@RequestMapping("/direccion")
public class DireccionController {
    
    @Autowired
    private IDireccionService dService;

    @RequestMapping("/bienvenido")
    public String irPaginaBienvenida() {
        return "bienvenido";
    }

    @RequestMapping("/")
    public String irPaginaListadoDirecciones(Map<String, Object> model) {
        model.put("listaDirecciones", dService.listar());
        return "listDireccion";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("direccion", new Direccion());
        return "direccion";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Direccion objDireccion, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "direccion";
        } else {
            boolean flag = dService.registrar(objDireccion);
            if (flag) {
                return "redirect:/direccion/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/direccion/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Direccion> objDireccion = dService.listarId(id);
        if (objDireccion == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/direccion/listar";
        } else {
            model.addAttribute("direccion", objDireccion);
            return "direccion";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                dService.eliminar(id);
                model.put("listaDirecciones", dService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaDirecciones", dService.listar());
        }
        return "listDireccion";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaDirecciones", dService.listar());
        return "listDireccion";
    }
}
