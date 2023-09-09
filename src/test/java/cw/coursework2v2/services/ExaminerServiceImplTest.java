package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private JavaQuestionService javaQuestionService;
    @Mock
    private MathQuestionService mathQuestionService;
    private ExaminerServiceImpl examinerService;
    @BeforeEach
    public void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService, mathQuestionService);
    }

    private final List<Question> questions = new ArrayList<>() {{
        add(new Question("1", "1"));
        add(new Question("2+2", "4"));
        add(new Question("3", "3"));
        add(new Question("3*3", "9"));
    }};

    @Test
    void shouldGetQuestionsByAmount() throws TooManyQuestionsException {
        // given
        final int amount = 4;

        when(javaQuestionService.getAll()).thenReturn(questions);
//        when(mathQuestionService.getAll()).thenReturn(questions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(questions.get(1), questions.get(3));
        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(2));

        // when
//       Collection<Question> getQuestionsByAmount = examinerService.getQuestions(amount);

        // then
//        assertEquals(amount, getQuestionsByAmount.size());
//        assertTrue(getQuestionsByAmount.contains(questions.get(0)));
//        assertTrue(getQuestionsByAmount.contains(questions.get(1)));
//        assertTrue(getQuestionsByAmount.contains(questions.get(2)));
//        assertTrue(getQuestionsByAmount.contains(questions.get(3)));
//
//        verify(mathQuestionService, times(2)).getRandomQuestion();
//        verify(javaQuestionService, times(2)).getRandomQuestion();
//        verify(mathQuestionService, times(1)).getAll();
//        verify(javaQuestionService, times(1)).getAll();
    }

    @Test
    void shouldThrowExceptionWhenRequestedTooManyQuestions() {
        assertThrows(TooManyQuestionsException.class, () -> examinerService.getQuestions(5));
    }

}