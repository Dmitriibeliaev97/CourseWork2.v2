package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.interfaces.QuestionService;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionRepository repositoryMock;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    private final List<Question> mathQuestions = new ArrayList<>() {{
        add(new Question("2+2", "4"));
        add(new Question("3*3", "9"));
        add(new Question("6-4", "2"));
    }};

    @Test
    void shouldAddNewQuestion() {
        // given
        when(repositoryMock.add(eq(mathQuestions.get(0)))).thenReturn(mathQuestions.get(0));
        // when

        // then
        assertEquals(mathQuestions.get(0), mathQuestionService.add(mathQuestions.get(0)));

        verify(repositoryMock, times(1)).add(mathQuestions.get(0));
    }


    @Test
    void shouldAddQuestion() {
        Question expected = mathQuestions.get(0);
        Question actual = new Question("2+2", "4");

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveQuestion() {
        // given
        when(repositoryMock.remove(eq(mathQuestions.get(0)))).thenReturn(mathQuestions.get(0));
        // when

        // then
//        assertEquals(mathQuestions.get(0), mathQuestionService.remove(mathQuestions.get(0)));

        verify(repositoryMock, times(1)).remove(mathQuestions.get(0));
    }

    @Test
    void shouldThrowExceptionWhenNotFoundQuestion() {
        // given
        Question question = new Question("5", "5");
        when(repositoryMock.remove(eq(question))).thenThrow(QuestionIsNotFoundException.class);
        // when

        // then

        assertThrows(QuestionIsNotFoundException.class, () -> mathQuestionService.remove(question));

        verify(repositoryMock, times(1)).remove(question);
    }

    @Test
    void shouldGetAllQuestions() {
        // given
        when(repositoryMock.getAll()).thenReturn(mathQuestions);
        // when

        // then
        assertEquals(mathQuestions, mathQuestionService.getAll());

        verify(repositoryMock, times(1)).getAll();
    }
    @Test
    void shouldThrowExceptionWhenSetIsEmpty() {
        // given
        mathQuestions.clear();
        when(repositoryMock.getAll()).thenThrow(SetIsEmpty.class);
        // when

        // then

        assertThrows(SetIsEmpty.class, () -> mathQuestionService.getAll());

        verify(repositoryMock, times(1)).getAll();
    }
}