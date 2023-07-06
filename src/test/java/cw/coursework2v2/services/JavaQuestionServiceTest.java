package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.interfaces.QuestionRepository;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class JavaQuestionServiceTest {
    @Mock
    private QuestionRepository repositoryMock;
    @InjectMocks
    private JavaQuestionService javaQuestionService;

    private final List<Question> javaQuestions = new ArrayList<>() {{
        add(new Question("1", "1"));
        add(new Question("2", "2"));
        add(new Question("3", "3"));
    }};

    @Test
    void shouldAddNewQuestion() {
        // given
        when(repositoryMock.add(eq(javaQuestions.get(0)))).thenReturn(javaQuestions.get(0));
        // when

        // then
        assertEquals(javaQuestions.get(0), javaQuestionService.add(javaQuestions.get(0)));

        verify(repositoryMock, times(1)).add(javaQuestions.get(0));
    }

    @Test
    void shouldAddQuestion() {
        Question expected = javaQuestions.get(0);
        Question actual = new Question("1", "1");

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveQuestion() {
        // given
        when(repositoryMock.remove(eq(javaQuestions.get(0)))).thenReturn(javaQuestions.get(0));
        // when

        // then
        assertEquals(javaQuestions.get(0), javaQuestionService.remove(javaQuestions.get(0)));

        verify(repositoryMock, times(1)).remove(javaQuestions.get(0));
    }

    @Test
    void shouldThrowExceptionWhenNotFoundQuestion() {
        // given
        Question question = new Question("5", "5");
        when(repositoryMock.remove(eq(question))).thenThrow(QuestionIsNotFoundException.class);
        // when

        // then

        assertThrows(QuestionIsNotFoundException.class, () -> javaQuestionService.remove(question));

        verify(repositoryMock, times(1)).remove(question);
    }

    @Test
    void shouldGetAllQuestions() {
        // given
        when(repositoryMock.getAll()).thenReturn(javaQuestions);
        // when

        // then
        assertEquals(javaQuestions, javaQuestionService.getAll());

        verify(repositoryMock, times(1)).getAll();
    }

    @Test
    void shouldThrowExceptionWhenSetIsEmpty() {
        // given
        javaQuestions.clear();
        when(repositoryMock.getAll()).thenThrow(SetIsEmpty.class);
        // when

        // then

        assertThrows(SetIsEmpty.class, () -> javaQuestionService.getAll());

        verify(repositoryMock, times(1)).getAll();
    }
}