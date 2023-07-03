package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
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

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

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
        // given
        final int amount = 3;
        final Collection<Question> randomQuestions = new HashSet<>(questions);

        when(questionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(1), questions.get(2));
        when(questionService.getAll()).thenReturn(randomQuestions);

        // when
        Collection<Question> getQuestionsByAmount = examinerService.getQuestions(amount);

        // then
        Assertions.assertEquals(randomQuestions, getQuestionsByAmount);

        verify(questionService, times(3)).getRandomQuestion();
        verify(questionService, times(3)).getAll();
    }

    @Test
    void shouldThrowExceptionWhenRequestedTooManyQuestions () {
        assertThrows (TooManyQuestionsException.class, () -> examinerService.getQuestions(4));
    }

}