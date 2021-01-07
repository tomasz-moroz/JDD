package pl.jjd.jjd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.jjd.jjd.utils.JsonReader;


@Controller
public class ExportJsonController {


    private JsonReader jsonReader;

    public ExportJsonController(JsonReader jsonReader) {
        this.jsonReader = jsonReader;
    }

    @GetMapping(path = "/template/export")
    public String export(Model model){
        try {

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return "exportJson";
    }
}
