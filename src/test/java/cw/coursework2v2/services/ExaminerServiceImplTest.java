package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.TooManyQuestionsException;
import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    @Qualifier("javaQuestionService")
    private QuestionService javaQuestionService;
    @Mock
    @Qualifier("mathQuestionService")
    private QuestionService mathQuestionService;
    @InjectMocks
    private ExaminerServiceImpl examinerService;

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
        when(mathQuestionService.getAll()).thenReturn(questions);
        when(mathQuestionService.getRandomQuestion()).thenReturn(questions.get(1), questions.get(3));
        when(javaQuestionService.getRandomQuestion()).thenReturn(questions.get(0), questions.get(2));

        // when
        Collection<Question> getQuestionsByAmount = examinerService.getQuestions(amount);

        // then
        Assertions.assertEquals(amount, getQuestionsByAmount.size());
        Assertions.assertTrue(getQuestionsByAmount.contains(questions.get(0)));
        Assertions.assertTrue(getQuestionsByAmount.contains(questions.get(1)));
        Assertions.assertTrue(getQuestionsByAmount.contains(questions.get(2)));
        Assertions.assertTrue(getQuestionsByAmount.contains(questions.get(3)));


//        org.assertj.core.api.Assertions.assertThat(getQuestionsByAmount)
//                .hasSize(amount)
//                .containsExactlyInAnyOrder(questions.get(0), questions.get(1), questions.get(2), questions.get(3));

        verify(mathQuestionService, times(2)).getRandomQuestion();
        verify(javaQuestionService, times(2)).getRandomQuestion();
        verify(mathQuestionService, times(2)).getAll();
        verify(javaQuestionService, times(2)).getAll();
    }

    @Test
    void shouldThrowExceptionWhenRequestedTooManyQuestions () {
        assertThrows (TooManyQuestionsException.class, () -> examinerService.getQuestions(5));
    }

}