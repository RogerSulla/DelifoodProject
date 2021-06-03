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

import pe.edu.upc.model.ObjetivoNutricional;
import pe.edu.upc.service.IObjNutricionalService;

@Controller
@RequestMapping("/ObjNutricional")
public class ObjNutricionalController {
    
    @Autowired
    private IObjNutricionalService oService;

    @RequestMapping("/")
    public String irPaginaListadoObjNutricional(Map<String, Object> model) {
        model.put("listaObjNutricional", oService.listar());
        return "listObjNutriciojnal";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("ObjNutricional", new ObjetivoNutricional());
        return "ObjNutricional";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute ObjetivoNutricional objNutricional, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "ObjNutricional";
        } else {
            boolean flag = oService.registrar(objNutricional);
            if (flag) {
                return "redirect:/ObjNutricional/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/ObjNutricional/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<ObjetivoNutricional> objNutricional = oService.listarId(id);
        if (objNutricional == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/ObjNutricional/listar";
        } else {
            model.addAttribute("ObjNutricional", objNutricional);
            return "ObjNutricional";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                oService.eliminar(id);
                model.put("listaObjNutricional", oService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaObjNutricional", oService.listar());
        }
        return "listObjNutricional";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaObjNutricional", oService.listar());
        return "listObjNutricional";
    }
}
