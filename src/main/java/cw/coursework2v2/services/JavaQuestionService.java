package cw.coursework2v2.services;


import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class JavaQuestionService implements QuestionService {
    Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) throws QuestionIsNotFoundException {
        for (int i = 0; i < questions.size(); i++) {
            if (questions.contains(question)) {
                questions.remove(question);
            } else {
                throw new QuestionIsNotFoundException("Вопрос не найден");
            }
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        for (int i = 0; i < questions.size(); i++) {
            System.out.println(i);
            if (questions.isEmpty()) {
                throw new SetIsEmpty("Список вопросов пуст");
            }
        }
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        for (int i = 0; i < questions.size(); i++) {
            Random randomQuestion = null;
            randomQuestion.nextInt(10);
        }
        return null;
    }
}
