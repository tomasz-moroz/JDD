package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.jjd.jjd.service.JsonReaderService;

import java.io.IOException;


@Controller
public class ExportJsonController {


    private JsonReaderService jsonReader;

    public ExportJsonController(JsonReaderService jsonReader) {
        this.jsonReader = jsonReader;
    }

    @GetMapping(path = "/template/export")
    public String export(Model model) throws IOException {

        model.addAttribute("save", jsonReader.exportJson());
        jsonReader.exportJson();

        return "exportJson";
    }
}
