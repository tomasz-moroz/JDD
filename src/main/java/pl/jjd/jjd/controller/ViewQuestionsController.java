package pl.jjd.jjd.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

import java.util.*;

@Controller
public class ViewQuestionsController {

    private QuestionService questionService;

    public ViewQuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    @RequestMapping(path = "/viewQuestions")
    public String getViewQuestions(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "25") Integer size, Model model) {
        Page<QuestionDto> questionDtoPage = questionService.findAll(PageRequest.of(page,size));
        List<QuestionDto> questionDtoList = questionDtoPage.getContent();
        model.addAttribute("questionList", questionDtoList);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", questionDtoPage.getTotalPages());
        model.addAttribute("totalItems", questionDtoPage.getTotalElements());
        return "viewQuestions";
    }
}
