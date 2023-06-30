package cw.coursework2v2.services;


import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.interfaces.ExaminerService;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }
    @Override
    public Collection<Question> getQuestions(int amount) throws TooManyQuestionsException {
        Set<Question> randomQuestions = new HashSet<>();
        randomQuestions.add(questionService.getRandomQuestion());
        if (random.nextInt() > randomQuestions.size()) {
            throw new TooManyQuestionsException();
        }
        return randomQuestions;
    }
}
