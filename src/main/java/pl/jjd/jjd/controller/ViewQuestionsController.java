package pl.jjd.jjd.controller;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.jjd.jjd.dto.QuestionDto;
import pl.jjd.jjd.service.QuestionService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class ViewQuestionsController {

    private QuestionService questionService;

    public ViewQuestionsController(QuestionService questionService) {
        this.questionService = questionService;
    }


    @GetMapping
    @RequestMapping(path = "/viewQuestions/{page}")
    public String findPaginated(@PathVariable(value = "page") int page,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 25;
        Page<QuestionDto> questionDtoPage = questionService.findAllWithPaginationAndSorting(page, pageSize, sortField, sortDir);
        List<QuestionDto> questionDtoList = questionDtoPage.getContent();
        int totalPages = questionDtoPage.getTotalPages();
        long totalItems = questionDtoPage.getTotalElements();
        List<Integer> numberOfPages = IntStream.rangeClosed(0, totalPages-1)
                .boxed().collect(Collectors.toList());

        model.addAttribute("questionList", questionDtoList);
        model.addAttribute("page", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("totalItems", totalItems);
        model.addAttribute("listOfNumbers", numberOfPages);

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc")?"desc":"asc");
        return "viewQuestions";
    }

    @GetMapping(path = "/viewQuestions/")
    public String viewListOfQuestions(Model model) {
        return findPaginated(1, "category", "asc", model);
    }

    @GetMapping(path = "/deleteQuestion/{id}")
    public String deleteQuestion(@PathVariable(value = "id") long id) {
        questionService.delete(id);
        return "redirect:/viewQuestions/0";
    }

    @RequestMapping(path = "/showFormForUpdate/{id}")
    public String edit(@PathVariable(value = "id") long id, Model model, QuestionDto questionDto) throws ChangeSetPersister.NotFoundException {
        updateQuestion(id, model, questionDto);
        return "updateQuestion";
    }

    @PostMapping(path = "/showFormForUpdate/{id}/edit")
    public String updateQuestion(@PathVariable(value = "id") long id, Model model, QuestionDto questionDto) throws ChangeSetPersister.NotFoundException {
        model.addAttribute("question", questionDto.getQuestion());
        model.addAttribute("answer", questionDto.getQuestion());
        model.addAttribute("category", questionDto.getCategory());
        questionService.edit(id,questionDto);
        return "redirect:/viewQuestions/0";
    }

}
