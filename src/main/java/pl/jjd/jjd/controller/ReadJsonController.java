package pl.jjd.jjd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jjd.jjd.api.FileReader;
import pl.jjd.jjd.service.QuestionService;

import java.io.IOException;

@Controller
public class ReadJsonController {

    private final QuestionService questionService;
    private final FileReader fileReader;

    public ReadJsonController(QuestionService questionService, FileReader fileReader) {
        this.questionService = questionService;
        this.fileReader = fileReader;
    }


    @GetMapping(path = "/read")
    public String export(Model model) throws IOException {
        model.addAttribute("read", fileReader.read());
        questionService.saveQuestionList(fileReader.read());

        return "readJson";
    }
}
