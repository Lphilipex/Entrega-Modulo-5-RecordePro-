package com.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.agencia.model.Usuario;
import com.agencia.service.UsuarioService;

@Controller
public class UsuarioController {

    private final UsuarioService userService;

    @Autowired
    public UsuarioController(UsuarioService userService) {
        this.userService = userService;
    }

    @GetMapping("/formulario-usuario")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "formulario-usuario";
    }

    @PostMapping("/salvar-usuario")
    public String salvarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        userService.salvar(usuario);
        return "redirect:/formulario-usuario";
    }


    @GetMapping("/listar-usuarios")
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", userService.listarTodos());
        return "lista-usuarios";
    }

    @GetMapping("/editar-usuario/{id}")
    public String mostrarFormularioEdicao(@PathVariable Long id, Model model) {
        Usuario usuario = userService.buscarPorId(id);
        model.addAttribute("usuario", usuario);
        return "formulario-edicao-usuario";
    }

    @PostMapping("/atualizar-usuario/{id}")
    public String atualizarUsuario(@PathVariable Long id, @ModelAttribute("usuario") Usuario usuarioAtualizado) {
        usuarioAtualizado.setId(id);
        userService.atualizar(usuarioAtualizado);
        return "redirect:/lista-de-cadastro"; 
    }
}
