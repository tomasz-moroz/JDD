package pl.jjd.jjd.service;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<QuestionDto> findAllWithPaginationAndSorting() {
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

    public Iterable<Question> saveQuestionList(List<Question> questionList) {
        return questionRepository.saveAll(questionList);
    }

    public QuestionDto findRandomQuestion() {
        List<Question> questionList = (List<Question>) questionRepository.findAll();
        List<QuestionDto> questionDtoList = questionList.stream().map(entity -> new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory())).collect(Collectors.toList());
        Random random = new Random();
        QuestionDto randomQuestion = questionDtoList.get(random.nextInt(questionList.size()));
        return randomQuestion;
    }

    public List<QuestionDto> searchForQuestion(String chars) {
        if (chars != null || !chars.isBlank()) {
            List<QuestionDto> found = new ArrayList<>();
            for (QuestionDto foundQuestion : findAllWithPaginationAndSorting()) {
                if (foundQuestion.getQuestion().toLowerCase().contains(chars.toLowerCase())) {
                    found.add(foundQuestion);
                }
            }
            return found;
        }
        return null;
    }

    public Page <QuestionDto> findAllWithPaginationAndSorting(int page, int pageSize, String sortField, String sortDirection){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
        Pageable pageable = PageRequest.of(page, pageSize, sort);
        return questionRepository.findAll(pageable).map(entity -> new QuestionDto(entity.getId(), entity.getQuestion(), entity.getAnswer(), entity.getCategory()));
    }

}
