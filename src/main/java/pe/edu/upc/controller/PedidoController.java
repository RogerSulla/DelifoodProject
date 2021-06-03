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

import pe.edu.upc.model.Pedido;
import pe.edu.upc.service.IPedidoService;

@Controller
@RequestMapping("/pedido")
public class PedidoController {
    
    @Autowired
    private IPedidoService pService;

    @RequestMapping("/")
    public String irPaginaListadoPedidos(Map<String, Object> model) {
        model.put("listaPedidos", pService.listar());
        return "listPedido";
    }

    @RequestMapping("/irRegistrar")
    public String irPaginaRegistrar(Model model) {
        model.addAttribute("pedido", new Pedido());
        return "pedido";
    }

    @RequestMapping("/registrar")
    public String registrar(@ModelAttribute Pedido objPedido, BindingResult binRes, Model model) throws ParseException {
        if (binRes.hasErrors()) {
            return "pedido";
        } else {
            boolean flag = pService.registrar(objPedido);
            if (flag) {
                return "redirect:/pedido/listar";
            } else {
                model.addAttribute("mensaje", "Ocurrió un error");
                return "redirect:/pedido/irRegistrar";
            }
        }
    }

    @RequestMapping("/modificar/{id}")
    public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) throws ParseException {
        Optional<Pedido> objPedido = pService.listarId(id);
        if (objPedido == null) {
            objRedir.addFlashAttribute("mensaje", "Ocurrió un error");
            return "redirect:/pedido/listar";
        } else {
            model.addAttribute("pedido", objPedido);
            return "pedido";
        }
    }

    @RequestMapping("/eliminar")
    public String eliminar(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
        try {
            if (id != null && id > 0) {
                pService.eliminar(id);
                model.put("listaPedidos", pService.listar());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            model.put("mensaje", "Ocurrió un error");
            model.put("listaPedidos", pService.listar());
        }
        return "listPedido";
    }

    @RequestMapping("/listar")
    public String listar(Map<String, Object> model) {
        model.put("listaPedidos", pService.listar());
        return "listPedido";
    }
}
