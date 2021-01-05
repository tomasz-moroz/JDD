package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping(path ="/index")
    public String index(Model model){
        model.addAttribute("title", "To jest tytul");
        return "index";
    }
}
