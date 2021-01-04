package pl.jjd.jjd.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.jjd.jjd.dto.QuestionDto;

import javax.validation.Valid;

import pl.jjd.jjd.service.QuestionService;

@RestController
@RequestMapping(path ="/questions")
public class QuestionController {

    private QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/list")
    public Iterable<QuestionDto> questions() {
        return questionService.findAll();
    }

    @PostMapping
    public QuestionDto save(@Valid @RequestBody QuestionDto questionDto) {
        return questionService.saveQuestion(questionDto);
    }

    @GetMapping(path = "/{id}")
    public QuestionDto findById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return questionService.findById(id);
    }

    @PutMapping(path = "/{id}")
    public QuestionDto edit(@PathVariable Long id, @Valid @RequestBody QuestionDto questionDto) throws ChangeSetPersister.NotFoundException {
        return questionService.edit(id, questionDto);
    }
    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        questionService.delete(id);
    }

}
