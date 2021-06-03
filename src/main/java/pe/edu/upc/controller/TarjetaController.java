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

import pe.edu.upc.model.Tarjeta;
import pe.edu.upc.service.ITarjetaService;

@Controller
@RequestMapping("/tarjeta")
public class TarjetaController {
    
    @Autowired
    private ITarjetaService tService;

    @RequestMapping("/")
    public String irPaginaListadoTarjetas(Map<String, Object> model) {
        model.put("listaTarjetas", tService.listar());
        return "listTarjeta";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("tarjeta", new Tarjeta());
        return "tarjeta";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Tarjeta objTarjeta, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "tarjeta";
        } else {
            boolean flag = tService.registrar(objTarjeta);
            if (flag) {
                return "redirect:/tarjeta/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/tarjeta/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Tarjeta> objtarjeta = tService.listarId(id);
        if (objtarjeta == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/tarjeta/listar";
        } else {
            model.addAttribute("tarjeta", objtarjeta);
            return "tarjeta";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                tService.eliminar(id);
                model.put("listaTarjetas", tService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaTarjetas", tService.listar());
        }
        return "listTarjeta";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaTarjetas", tService.listar());
        return "listTarjeta";
    }
}
