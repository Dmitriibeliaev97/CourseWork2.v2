package cw.coursework2v2.services;


import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.stereotype.Service;

import java.util.*;

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
        if (questions.contains(question)) {
            questions.remove(question);
        } else {
            throw new QuestionIsNotFoundException("Вопрос не найден");
        }
        return question;
    }

    @Override
    public Collection<Question> getAll() {
            if (questions.isEmpty()) {
                throw new SetIsEmpty("Список вопросов пуст");
            }
        return questions;
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
