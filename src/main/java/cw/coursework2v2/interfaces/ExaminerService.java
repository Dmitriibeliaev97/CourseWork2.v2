package cw.coursework2v2.interfaces;


import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount) throws TooManyQuestionsException;
}
