package pl.jjd.jjd.service;

import org.springframework.stereotype.Service;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.entity.Question;
import pl.jjd.jjd.reposiotry.QuestionRepository;

import java.util.List;
import java.util.Random;

@Service
public class LuckyShotService {

    QuestionService questionService;

    public LuckyShotService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public QuestionDto findRandomQuestion() {
        List<QuestionDto> questionList = questionService.findAll();
        Random random = new Random();
        QuestionDto randomQuestion = questionList.get(random.nextInt(questionList .size()));
        return randomQuestion;
    }


}
