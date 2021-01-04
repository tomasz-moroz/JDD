package pl.jjd.jjd.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import pl.jjd.jjd.entity.Question;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {

    private Long id;

    private String question;

    private String answer;

    private String category;

    public QuestionDto questionToDto(Question question){
        QuestionDto questionDto = new QuestionDto(
                question.getId(),
                question.getQuestion(),
                question.getAnswer(),
                question.getCategory());
        return questionDto;
    }
    public Question dtoToQuestion(QuestionDto questionDto){
        Question question = new Question();
        question.setQuestion(questionDto.getQuestion());
        question.setAnswer(questionDto.getAnswer());
        question.setCategory(questionDto.getCategory());
        return question;
    }
}
