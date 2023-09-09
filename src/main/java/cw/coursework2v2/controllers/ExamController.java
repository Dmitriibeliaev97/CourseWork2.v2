package cw.coursework2v2.controllers;


import cw.coursework2v2.exceptions.MethodNotAllowed;
import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.model.Question;
import cw.coursework2v2.services.ExaminerServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/exam")
public class ExamController {
    private final ExaminerServiceImpl examinerService;

    public ExamController(ExaminerServiceImpl examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public Collection<Question> getQuestions(@PathVariable("amount") int amount) throws TooManyQuestionsException, MethodNotAllowed {
        return examinerService.getQuestions(amount);
    }
}
