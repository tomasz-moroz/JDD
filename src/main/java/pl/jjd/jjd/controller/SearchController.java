package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jjd.jjd.service.QuestionService;

@Controller
public class SearchController {

    QuestionService questionService;

    public SearchController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(path = "/searchQuestion")
    public String search() {
        return "searchQuestion";
    }

    @GetMapping(path = "/search")
    public String searchQuestion(Model model, @RequestParam(name = "questionSearch") String questionSearch) {
        model.addAttribute("foundList", questionService.searchForQuestion(questionSearch));
        return "searchQuestion";
    }
}
