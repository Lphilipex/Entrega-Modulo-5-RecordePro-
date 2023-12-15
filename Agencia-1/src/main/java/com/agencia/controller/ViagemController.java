package com.agencia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.agencia.model.Viagem;
import com.agencia.service.ViagemService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class ViagemController {

    private final ViagemService viagemService;

    @Autowired
    public ViagemController(ViagemService viagemService) {
        this.viagemService = viagemService;
    }
    
    @GetMapping("/editar-viagem/{id}")
    public String editarViagem(@PathVariable("id") Long id, Model model) {
        Viagem viagem = viagemService.buscarViagemPorId(id);

        if (viagem == null) {
            return "paginaDeErro";
        }

        model.addAttribute("viagem", viagem);

        return "editarViagem";
    }

    @PostMapping("/salvar-viagem")
    public String salvarViagem(@ModelAttribute("viagem") Viagem viagem) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (viagem.getDataPartidaString() != null && !viagem.getDataPartidaString().isEmpty()) {
                Date dataPartida = dateFormat.parse(viagem.getDataPartidaString());
                viagem.setDataPartida(dataPartida);
            } else {
                return "redirect:/pagina-de-erro";
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return "redirect:/pagina-de-erro";
        }

        viagemService.salvarViagem(viagem);

        return "redirect:/formulario-usuario";
    }
    @PostMapping("/atualizar-viagem/{id}")
    public String atualizarViagem(@PathVariable Long id, @ModelAttribute("viagem") Viagem viagemAtualizada) {
        viagemAtualizada.setId(id);
        viagemService.atualizarViagem(viagemAtualizada);
        return "redirect:/lista-de-cadastro";
    }


}
