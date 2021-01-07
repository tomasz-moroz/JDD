package pl.jjd.jjd.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.stereotype.Component;
import pl.jjd.jjd.entity.Question;
import pl.jjd.jjd.service.QuestionService;

import java.util.*;
import java.io.IOException;
import java.io.InputStream;

@Component
public class FileReader {

    QuestionMapper questionMapper;

    public FileReader(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public List<QuestionsApi>  readerFromFile() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<QuestionsApi> typeReference = new TypeReference<QuestionsApi>() {};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/1.json");
        List<QuestionsApi> questionsApi = (List<QuestionsApi>) objectMapper.readValue(inputStream, typeReference);
        System.out.println("Meals saved");
        return questionsApi;
    }
    public List<Question> read() throws IOException {
        List<QuestionsApi> questionsApiList = readerFromFile();
        List<Question>questionList = questionMapper.mapQuestionsFromJsonFile(questionsApiList);
        return questionList;
    }
}
