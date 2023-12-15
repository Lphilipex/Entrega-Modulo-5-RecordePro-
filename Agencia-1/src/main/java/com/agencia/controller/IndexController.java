package com.agencia.controller;

import com.agencia.model.IndexModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(Model model) {
        IndexModel indexModel = new IndexModel();
        indexModel.setWelcomeMessage("Bem-vindo à nossa página!");

        model.addAttribute("indexModel", indexModel);
        return "index";
    }
}
