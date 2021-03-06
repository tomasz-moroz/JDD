package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

@Controller
public class LuckyShotController {

    public QuestionService questionService;

    public LuckyShotController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/luckyShot")
    public String showLuckyShot(Model model) {
        QuestionDto question = questionService.findRandomQuestion();
        model.addAttribute("question", question.getQuestion());
        model.addAttribute("category", question.getCategory());
        model.addAttribute("answer", question.getAnswer());
        return "luckyShot";
    }

}
