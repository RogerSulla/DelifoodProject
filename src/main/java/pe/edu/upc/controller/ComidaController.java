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

import pe.edu.upc.model.Comida;
import pe.edu.upc.service.IComidaService;

@Controller
@RequestMapping("/comida")
public class ComidaController {
    
    @Autowired
    private IComidaService cService;

    @RequestMapping("/")
    public String irPaginaListadoComidas(Map<String, Object> model) {
        model.put("listaComidas", cService.listar());
        return "listComidas";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("comida", new Comida());
        return "comida";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Comida objComida, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "comida";
        } else {
            boolean flag = cService.registrar(objComida);
            if (flag) {
                return "redirect:/comida/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/comida/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Comida> objComida = cService.listarId(id);
        if (objComida == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/comida/listar";
        } else {
            model.addAttribute("race", objComida);
            return "comida";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                cService.eliminar(id);
                model.put("listaComidas", cService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaComidas", cService.listar());
        }
        return "listComidas";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaComidas", cService.listar());
        return "listComidas";
    }
}
