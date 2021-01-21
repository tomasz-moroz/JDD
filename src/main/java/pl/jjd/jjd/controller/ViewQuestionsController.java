package pl.jjd.jjd.controller;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ViewQuestionsController {

    private QuestionService questionService;

    public ViewQuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping
    @RequestMapping(path = "/viewQuestions/{page}")
    public String findPaginated(@PathVariable(value = "page") int page, Model model) {
        int pageSize = 25;
        Page<QuestionDto> questionDtoPage = questionService.findAllWithPagination(page, pageSize);
        List<QuestionDto> questionDtoList = questionDtoPage.getContent();
        int totalPages = questionDtoPage.getTotalPages();
        long totalItems = questionDtoPage.getTotalElements();
        List<Integer> numberOfPages = IntStream.rangeClosed(1, totalPages)
                .boxed().collect(Collectors.toList());

        model.addAttribute("questionList", questionDtoList);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listOfNumbers", numberOfPages);
        return "viewQuestions";
    }

    @GetMapping(path ="/viewQuestions/")
    public String viewListOfQuestions(Model model) {
       return findPaginated(1, model);
    }

}
