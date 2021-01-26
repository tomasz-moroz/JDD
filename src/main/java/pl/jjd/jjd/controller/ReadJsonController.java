package pl.jjd.jjd.controller;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pl.jjd.jjd.service.JsonReaderService;

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


    @RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, ModelMap modelMap) throws IOException {
        modelMap.addAttribute("file", file);
        jsonReaderService.read(file);
        return "fileUploadView";
    }
}
