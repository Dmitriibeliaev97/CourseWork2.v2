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
public class JavaQuestionRepository implements QuestionRepository {
    Set<Question> javaQuestions = new HashSet<>();

    @PostConstruct
    public void setUp() {
        javaQuestions.add(new Question("Какие области данных в памяти Джава выделяют?", "Стек и куча"));
        javaQuestions.add(new Question("На какой структуре данных основывается LinkedList?", "Двусвязный список"));
        javaQuestions.add(new Question("Какие основные реализации интерфейса List?", "ArrayList / LinkedList"));
    }

    public JavaQuestionRepository() {
    }

    @PostConstruct
    public void init() {
        System.out.println("Repository is here");
    }

    @Override
    public Question add(Question question) {
        javaQuestions.add(question);
        return question;
    }


    @Override
    public Question remove(Question question) throws QuestionIsNotFoundException {
        if (javaQuestions.contains(question)) {
            javaQuestions.remove(question);
        } else {
            throw new QuestionIsNotFoundException("Вопрос не найден");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        if (javaQuestions.isEmpty()) {
            throw new SetIsEmpty("Список вопросов пуст");
        }
        return javaQuestions;

    }
}
