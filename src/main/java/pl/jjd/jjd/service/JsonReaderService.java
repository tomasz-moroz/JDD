package pl.jjd.jjd.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.jjd.jjd.api.QuestionMapper;
import pl.jjd.jjd.api.QuestionsApi;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.entity.Question;


import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.*;

@Service
public class JsonReaderService {

    QuestionService questionService;

    public JsonReaderService(QuestionService questionService) {
        this.questionService = questionService;
    }


    /*IMPORT*/

    public List<QuestionsApi>  readerFromFile(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<QuestionsApi> questionsApi = objectMapper.readValue(file.getBytes(), new TypeReference<List<QuestionsApi>>(){});
        System.out.println("Questions saved");
        return questionsApi;
    }
    public List<Question> read(MultipartFile file) throws IOException {
        List<QuestionsApi> questionsApiList = readerFromFile(file);
        QuestionMapper questionMapper = new QuestionMapper();
        List<Question>questionList = questionMapper.mapQuestionsFromJsonFile(questionsApiList);
        questionService.saveQuestionList(questionList);
        return questionList;
    }

    /*EXPORT*/

    public List<QuestionDto> exportJson() throws IOException {
        List<QuestionDto> questionDtoList = questionService.findAllWithPaginationAndSorting();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(Paths.get("/home/tmo/Desktop/JDD/src/main/resources/json/backup/"+nameFileBuilder()+".json").toFile(), questionDtoList);
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
