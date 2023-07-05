package cw.coursework2v2.model;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.interfaces.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
public class MathQuestionRepository implements QuestionRepository {
    Set<Question> mathQuestions = new HashSet<>();

    public MathQuestionRepository() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Repository is here");
    }

    @Override
    public Question add(Question question) {
        mathQuestions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) throws QuestionIsNotFoundException {
        if (mathQuestions.contains(question)) {
            mathQuestions.remove(question);
        } else {
            throw new QuestionIsNotFoundException("Вопрос не найден");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        if (mathQuestions.isEmpty()) {
            throw new SetIsEmpty("Список вопросов пуст");
        }
        return mathQuestions;

    }
}
