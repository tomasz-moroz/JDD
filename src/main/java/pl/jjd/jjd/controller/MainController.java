package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(path = "/login")
    public String login(){
        return "login";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }
}
