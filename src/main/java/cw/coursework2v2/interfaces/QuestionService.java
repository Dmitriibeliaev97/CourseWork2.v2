package cw.coursework2v2.interfaces;


import cw.coursework2v2.exceptions.MethodNotAllowed;
import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer) throws MethodNotAllowed;

    Question add(Question question) throws MethodNotAllowed;

    Question remove(Question question) throws QuestionIsNotFoundException, MethodNotAllowed;

    Collection<Question> getAll() throws MethodNotAllowed;

    Question getRandomQuestion();

}
