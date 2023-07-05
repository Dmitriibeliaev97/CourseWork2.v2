package cw.coursework2v2.interfaces;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface QuestionRepository {
    Question add(Question question);
    Question remove(Question question) throws QuestionIsNotFoundException;
    Collection<Question> getAll();
}
