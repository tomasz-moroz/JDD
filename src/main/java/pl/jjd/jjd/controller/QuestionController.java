package pl.jjd.jjd.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jjd.jjd.dto.QuestionDto;

import javax.validation.Valid;

import pl.jjd.jjd.service.QuestionService;

@RestController
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions/list")
    public Iterable<QuestionDto> questions() {
        return questionService.findAllWithPagination();
    }

    @PostMapping
    public QuestionDto save(@Valid @RequestBody QuestionDto questionDto) {
        return questionService.saveQuestion(questionDto);
    }

    @GetMapping(path = "/questions/{id}")
    public QuestionDto findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return questionService.findById(id);
    }

    @PutMapping(path = "/questions/{id}")
    public QuestionDto edit(@PathVariable Long id, @Valid @RequestBody QuestionDto questionDto) throws ChangeSetPersister.NotFoundException {
        return questionService.edit(id, questionDto);
    }
    @DeleteMapping(path = "/questions/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        questionService.delete(id);
    }

}
