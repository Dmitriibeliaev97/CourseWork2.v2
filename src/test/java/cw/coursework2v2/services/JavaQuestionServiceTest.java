package cw.coursework2v2.services;

import cw.coursework2v2.exceptions.QuestionIsNotFoundException;
import cw.coursework2v2.exceptions.SetIsEmpty;
import cw.coursework2v2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private Question question1;
    private Question question2;
    private Question question3;
    private JavaQuestionService questions;
    @BeforeEach
    public void setUp() {
        question1 = new Question("1", "1");
        question2 = new Question("2", "2");
        question3 = new Question("3", "3");

        questions = new JavaQuestionService(questions);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }
    @Test
    void shouldAddNewQuestion() {
        Question expected = questions.add("4", "4");
        Question actual = new Question("4", "4");

        assertEquals(expected, actual);
    }

    @Test
    void shouldAddQuestion() {
        Question expected = questions.add(question1);
        Question actual = new Question("1", "1");

        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveQuestion() {
        Question expected = questions.remove(question1);
        Question actual = new Question("1", "1");

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenNotFoundQuestion() {
        Question question = new Question("4", "4");
        assertThrows(QuestionIsNotFoundException.class, () -> questions.remove(question));
    }

    @Test
    void shouldGetAllQuestions() {
        Collection<Question> expected = questions.getAll();

        Set<Question> actual = new HashSet<>();
        actual.add(question1);
        actual.add(question2);
        actual.add(question3);

        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionWhenSetIsEmpty() {
        questions.remove(question1);
        questions.remove(question2);
        questions.remove(question3);
        assertThrows(SetIsEmpty.class, () -> questions.getAll());
    }
}