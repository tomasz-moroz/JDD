package pl.jjd.jjd.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import pl.jjd.jjd.dto.QuestionDto;


import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.*;

@Service
public class JsonReaderService {

    QuestionService questionService;

    public JsonReaderService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public List<QuestionDto> exportJson() throws IOException {
        List<QuestionDto> questionDtoList = questionService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(Paths.get("src/main/resources/json/backup "+nameFileBuilder()+".json").toFile(), questionDtoList);
        return questionDtoList;
    }

    public String nameFileBuilder() {
        TimeZone.setDefault(TimeZone.getTimeZone("CET"));
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String formattedDate = DateFormat
                .getDateTimeInstance(DateFormat.MEDIUM, DateFormat.SHORT)
                .format(date);
        return formattedDate;
    }
}
