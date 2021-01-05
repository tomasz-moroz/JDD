package pl.jjd.jjd.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.entity.Question;
import pl.jjd.jjd.exception.NotFoundException;
import pl.jjd.jjd.reposiotry.QuestionRepository;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionDto findById(Long id) throws ChangeSetPersister.NotFoundException {
        Question entity = questionRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);
        return new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory());
    }

    public List<QuestionDto> findAll() {
        List<Question> questionList = (List<Question>) questionRepository.findAll();
        return questionList.stream().map(entity -> new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory())).collect(Collectors.toList());
    }

    public QuestionDto saveQuestion(QuestionDto questionDto) {
        Question question = questionDto.dtoToQuestion(questionDto);
        Question entity = questionRepository.save(question);
        return new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory());
    }

    public void delete(Long id) {
        Question entity = questionRepository.findById(id).orElseThrow(NotFoundException::new);
        questionRepository.delete(entity);
    }

    public QuestionDto edit(Long id, QuestionDto questionDto) throws ChangeSetPersister.NotFoundException {
        Question question = questionRepository.findById(id).orElseThrow(ChangeSetPersister.NotFoundException::new);

        question.setQuestion(questionDto.getQuestion());
        question.setCategory(questionDto.getCategory());
        question.setAnswer(questionDto.getAnswer());
        Question entity = questionRepository.save(question);

        return new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory());
    }

}