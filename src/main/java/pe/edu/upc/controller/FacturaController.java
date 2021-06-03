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

import pe.edu.upc.model.Factura;
import pe.edu.upc.service.IFacturaService;

@Controller
@RequestMapping("/factura")
public class FacturaController {
    
    @Autowired
    private IFacturaService fService;

    @RequestMapping("/bienvenido")
    public String irPaginaBienvenida() {
        return "bienvenido";
    }

    @RequestMapping("/")
    public String irPaginaListadoFacturas(Map<String, Object> model) {
        model.put("listaFacturas", fService.listar());
        return "listFactura";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("factura", new Factura());
        return "factura";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Factura objFactura, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "factura";
        } else {
            boolean flag = fService.registrar(objFactura);
            if (flag) {
                return "redirect:/factura/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/factura/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Factura> objFactura = fService.listarId(id);
        if (objFactura == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/factura/listar";
        } else {
            model.addAttribute("factura", objFactura);
            return "factura";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                fService.eliminar(id);
                model.put("listaFacturas", fService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaFacturas", fService.listar());
        }
        return "listFactura";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaFacturas", fService.listar());
        return "listFactura";
    }
}
