package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {

    @GetMapping(path ="/start")
    public String start(){
        return "start";
    }

    @GetMapping(path ="/luckyShot")
    public String luckyShot(){
        return "luckyShot";
    }

    @GetMapping(path ="/categories")
    public String categories(){
        return "categories";
    }

    @GetMapping(path = "/template/form")
    public String questionPost(){
        return "questionPost";
    }

    @GetMapping(path ="/readJson")
    public String readJson(){
        return "readJson";
    }

    @GetMapping(path ="/exportJson")
    public String exportJson(){
        return "exportJson";
    }
}
