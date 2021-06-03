package pe.edu.upc.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.model.Usuario;
import pe.edu.upc.service.IUsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService uService;

    @RequestMapping("/login")
    public String irPaginaLogin() {
        return "login";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuario";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Usuario objUsuario, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "usuario";
        } else {
            boolean flag = uService.registrar(objUsuario);
            if (flag) {
                return "redirect:/usuario";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/usuario/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Usuario> objUsuario = uService.listarId(id);
        if (objUsuario == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/usuario/perfil";
        } else {
            model.addAttribute("usuario", objUsuario);
            return "redirect:/usuario/inicio";
        }
    }
}
