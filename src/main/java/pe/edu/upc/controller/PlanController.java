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

import pe.edu.upc.model.Plan;
import pe.edu.upc.service.IPlanService;

@Controller
@RequestMapping("/plan")
public class PlanController {
    
    @Autowired
    private IPlanService pService;

    @RequestMapping("/")
    public String irPaginaListadoPlanes(Map<String, Object> model) {
        model.put("listaPlanes", pService.listar());
        return "listPlan";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("plan", new Plan());
        return "plan";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Plan objPlan, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "plan";
        } else {
            boolean flag = pService.registrar(objPlan);
            if (flag) {
                return "redirect:/plan/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/plan/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Plan> objplan = pService.listarId(id);
        if (objplan == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/plan/listar";
        } else {
            model.addAttribute("plan", objplan);
            return "plan";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                pService.eliminar(id);
                model.put("listaPlanes", pService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaPlanes", pService.listar());
        }
        return "listPlan";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaPlanes", pService.listar());
        return "listPlan";
    }
}
