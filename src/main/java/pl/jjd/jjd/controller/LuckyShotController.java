package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.LuckyShotService;

@Controller
public class LuckyShotController {


    @GetMapping(path = "/template/luckyShot")
    public String showLuckyShot(Model model, LuckyShotService luckyShotService){
        QuestionDto question = luckyShotService.findRandomQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("category", question.getCategory());
        return "luckyShot";
    }


}
