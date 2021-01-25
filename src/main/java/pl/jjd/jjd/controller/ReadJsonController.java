package pl.jjd.jjd.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.jjd.jjd.api.FileReader;
import pl.jjd.jjd.service.JsonReaderService;
import pl.jjd.jjd.service.QuestionService;

import java.io.IOException;

@Controller
public class ReadJsonController {

    JsonReaderService jsonReaderService;

    public ReadJsonController(JsonReaderService jsonReaderService) {
        this.jsonReaderService = jsonReaderService;
    }

    @GetMapping(path = "/read")
    public String export()  {
        return "readJson";
    }

    @PostMapping(path = "/json-upload")
    public String upload(@RequestParam("file")MultipartFile file) throws IOException {
        jsonReaderService.read(file);
        return "readJson";
    }
}
