package cw.coursework2v2.services;


import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.interfaces.ExaminerService;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private final Random random = new Random();

    private final QuestionService javaQuestionService;
    private final QuestionService mathQuestionService;

    public ExaminerServiceImpl(@Qualifier("javaQuestionService") QuestionService javaQuestionService,
                               @Qualifier("mathQuestionService") QuestionService mathQuestionService) {
        this.javaQuestionService = javaQuestionService;
        this.mathQuestionService = mathQuestionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) throws TooManyQuestionsException {
        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
            throw new TooManyQuestionsException();
        }
        Set<Question> randomQuestions = new HashSet<>();
        while (randomQuestions.size() < amount) {
            randomQuestions.add(javaQuestionService.getRandomQuestion());
            if (randomQuestions.size() == amount)
                break;
            randomQuestions.add(mathQuestionService.getRandomQuestion());
        }
        return randomQuestions;
    }
}
