package pl.jjd.jjd.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jjd.jjd.api.FileReader;
import pl.jjd.jjd.service.QuestionService;

import java.io.IOException;

public class ReadJsonController {

    QuestionService questionService;

    public ReadJsonController(QuestionService questionService) {
        this.questionService = questionService;
    }

    FileReader fileReader;

    public ReadJsonController(FileReader fileReader) {
        this.fileReader = fileReader;
    }
    @GetMapping(path = "/template/read")
    public String export(Model model) throws IOException {
        model.addAttribute("read", fileReader.read());
        questionService.saveQuestionList(fileReader.read());

        return "readJson";
    }
}
