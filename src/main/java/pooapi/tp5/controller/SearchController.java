package pooapi.tp5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pooapi.tp5.model.Meteo;

@Controller

    public class SearchController {
        @GetMapping("/adresse")
        public String meteoForm(Model model) {
            //model.addAttribute("meteo", new Meteo());
            return "meteo-search";
        }
    }

