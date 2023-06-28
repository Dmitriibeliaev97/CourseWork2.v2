package cw.coursework2v2.controllers;


import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    private final QuestionService questionService;

    public JavaQuestionController(QuestionService service) {
        this.questionService = service;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping()
    public Collection<Question> getQuestion() {
        return questionService.getAll();
    }

    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam("question") Question question,
                                   @RequestParam("answer") Question answer) {
        return questionService.remove(question);
    }

}
