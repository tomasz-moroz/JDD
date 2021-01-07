package pl.jjd.jjd.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.*;

@Component
public class JsonReader {

    QuestionService questionService;

    public JsonReader(QuestionService questionService) {
        this.questionService = questionService;
    }

    public void exportJson(){
        try {
        List<QuestionDto> questionDtoList = questionService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.writeValue(Paths.get("src/main/resources/json/backup "+nameFileBuilder()+".json").toFile(), questionDtoList);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
