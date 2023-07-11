package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.MethodNotAllowed;
import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MathQuestionService implements QuestionService {
    @Override
    public Question add(String question, String answer) throws MethodNotAllowed {
        throw new MethodNotAllowed();
    }

    @Override
    public Question add(Question question) throws MethodNotAllowed {
        throw new MethodNotAllowed();
    }

    @Override
    public Question remove(Question question) throws MethodNotAllowed {
        throw new MethodNotAllowed();
    }

    @Override
    public Collection<Question> getAll() throws MethodNotAllowed {
        throw new MethodNotAllowed();
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int firstNumber = random.nextInt(9);
        int secondNumber = random.nextInt(9);
        String randomQuestionsPlus = firstNumber + " + " + secondNumber;
        String randomQuestionsMinus = firstNumber + " - " + secondNumber;
        String randomQuestionsMultiply = firstNumber + " * " + secondNumber;
        String randomQuestionsDivision = firstNumber + " / " + secondNumber;
        List<Question> questionList = new ArrayList<>() {{
            add(new Question(randomQuestionsPlus, " = " + firstNumber + secondNumber));
            add(new Question(randomQuestionsMinus, " = " + (firstNumber - secondNumber)));
            add(new Question(randomQuestionsMultiply, " = " + firstNumber * secondNumber));
            add(new Question(randomQuestionsDivision, " = " + firstNumber / secondNumber));
        }};
        return questionList.get(random.nextInt(questionList.size()));
    }
}
