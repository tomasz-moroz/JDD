package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

@Controller
public class QuestionPostController {

    private QuestionService questionService;

    public QuestionPostController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(path = "/addQuestion")
    public String addQuestion(){
        return "questionPost";
    }

    @PostMapping(path = "/questionPost")
    public String questionPost(Model model, QuestionDto questionDto){

        model.addAttribute("question", questionDto.getQuestion());
        model.addAttribute("answer", questionDto.getQuestion());
        model.addAttribute("category", questionDto.getCategory());

        questionService.saveQuestion(questionDto);
        return "questionPost";
    }


}
