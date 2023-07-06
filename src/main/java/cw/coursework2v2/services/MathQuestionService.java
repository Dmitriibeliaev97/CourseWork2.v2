package cw.coursework2v2.services;

import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

public class MathQuestionService implements QuestionService {
    @Qualifier("mathQuestionRepository")
    private final QuestionRepository mathQuestionRepository;

    Set<Question> questions = new HashSet<>();

    public MathQuestionService(QuestionRepository mathQuestionRepository) {
        this.mathQuestionRepository = mathQuestionRepository;
    }

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
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
        List<Question> questionList = new ArrayList<>();
        Random random = new Random();
        for (Question i : questions) {
            questionList.add(i);
        }
        return questionList.get(random.nextInt(questionList.size()));
    }
}
