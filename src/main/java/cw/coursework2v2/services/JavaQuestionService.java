package cw.coursework2v2.services;

import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {
    @Qualifier("javaQuestionRepository")
    private final QuestionRepository javaQuestionRepository;
    public JavaQuestionService(QuestionService javaQuestionRepository) {
        this.javaQuestionRepository = javaQuestionRepository;
    }
    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        return javaQuestionRepository.add(question);
    }

    @Override
    public Question remove(Question question) {
        return javaQuestionRepository.remove(question);
    }

    @Override
    public Collection<Question> getAll() {
        return javaQuestionRepository.getAll();
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
