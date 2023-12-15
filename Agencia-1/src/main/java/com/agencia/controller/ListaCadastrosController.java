package com.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

import com.agencia.model.Viagem;
import com.agencia.model.Usuario;
import com.agencia.service.UsuarioService;
import com.agencia.service.ViagemService;

@Controller
public class ListaCadastrosController {

    @Autowired
    private UsuarioService usuarioService;
    
    @Autowired
    private ViagemService viagemService;

    @GetMapping("/lista-de-cadastro")
    public String listarCadastros(Model model) {
        List<Usuario> listaUsuarios = usuarioService.listarTodos(); 
        List<Viagem> listaViagens = viagemService.listarTodos(); 

        model.addAttribute("listaUsuarios", listaUsuarios);
        model.addAttribute("listaViagens", listaViagens); 

        return "lista-de-cadastro"; 
    }
}
