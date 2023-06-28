package cw.coursework2v2.interfaces;


import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question) throws QuestionIsNotFoundException;

    Collection<Question> getAll();

    Question getRandomQuestion();

}
