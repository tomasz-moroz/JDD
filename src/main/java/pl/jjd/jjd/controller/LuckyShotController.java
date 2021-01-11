package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.LuckyShotService;
import pl.jjd.jjd.service.QuestionService;

@Controller
public class LuckyShotController {

    public QuestionService questionService;

    public LuckyShotController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/template/luckyShot")
    public String showLuckyShot(Model model, LuckyShotService luckyShotService) {
        QuestionDto question = questionService.findRandomQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("category", question.getCategory());
        return "luckyShot";
    }

    @GetMapping(path = "/template/randomQuestion")
    public String showRandom(Model model, LuckyShotService luckyShotService) {
        QuestionDto question = questionService.findRandomQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("answer", question.getAnswer());
        model.addAttribute("category", question.getCategory());
        return "luckyShot";
    }


}
