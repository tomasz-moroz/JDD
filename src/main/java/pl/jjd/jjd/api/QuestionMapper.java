package pl.jjd.jjd.api;

import org.springframework.stereotype.Component;
import pl.jjd.jjd.entity.Question;

import java.util.ArrayList;
import java.util.List;

@Component
public class QuestionMapper {

    public List<Question> mapQuestionsFromJsonFile(List<QuestionsApi> questionsApiList) {
        List<Question> questions = new ArrayList<>();
        for (QuestionsApi questionApi:questionsApiList) {
            questions.add(questionMapper(questionApi));
        }
        return questions;
    }

    public Question questionMapper(QuestionsApi questionsApi){
        Question question = new Question();
        question.setQuestion(questionsApi.getQuestion());
        question.setAnswer(questionsApi.getAnswer());
        question.setCategory(questionsApi.getCategory());
        return question;
    }
}
