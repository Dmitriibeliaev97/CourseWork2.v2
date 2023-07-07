package cw.coursework2v2.services;

import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    private final QuestionRepository mathQuestionRepository;

    public MathQuestionService(@Qualifier("mathQuestionRepository") QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        mathQuestionRepository.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return mathQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return mathQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return mathQuestionRepository.getAll();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        List<Question> questionList = new ArrayList<>(mathQuestionRepository.getAll());
        return questionList.get(random.nextInt(questionList.size()));
    }
}
