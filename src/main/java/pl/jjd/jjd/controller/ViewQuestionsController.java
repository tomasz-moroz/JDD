package pl.jjd.jjd.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

@Controller
public class ViewQuestionsController {

    private QuestionService questionService;

    public ViewQuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @RequestMapping(path = "/viewQuestions")
    public  String getList(){
        return "viewQuestions";
    }
}
