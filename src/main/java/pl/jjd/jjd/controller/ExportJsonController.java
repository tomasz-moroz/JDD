package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.jjd.jjd.service.JsonReaderService;

import java.io.IOException;


@Controller
public class ExportJsonController {


    private JsonReaderService jsonReader;

    public ExportJsonController(JsonReaderService jsonReader) {
        this.jsonReader = jsonReader;
    }

    @GetMapping(path = "/export")
    public String exportJson() {
        return "exportJson";
    }

    @GetMapping(path = "/export/getFile")
    public String export(@RequestParam String exportJson) throws IOException {
        if(exportJson.equals("save"))
            jsonReader.exportJson();
        return "exportJson";
    }
}
