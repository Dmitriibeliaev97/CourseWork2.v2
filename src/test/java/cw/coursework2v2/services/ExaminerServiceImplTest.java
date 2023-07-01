package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.AssertionErrors.assertEquals;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

    private final List<Question> questions = new ArrayList<>() {{
        add(new Question("1", "1"));
        add(new Question("2", "2"));
        add(new Question("3", "3"));
    }};

    @Test
    void shouldGetQuestionsByAmount() throws TooManyQuestionsException {
        final int amount = 3;
        final Collection<Question> randomQuestions = new HashSet<>(questions);
        for (Question question : questions) {
            randomQuestions.add(question);
        }
        when(questionService.getAll()).thenReturn(randomQuestions);

        Collection<Question> getQuestionsByAmount = examinerService.getQuestions(amount);

        Assertions.assertEquals(questions, getQuestionsByAmount);
    }

}