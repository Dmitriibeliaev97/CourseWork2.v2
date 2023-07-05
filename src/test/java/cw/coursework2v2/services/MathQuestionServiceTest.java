package cw.coursework2v2.services;

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

@ExtendWith(MockitoExtension.class)
class MathQuestionServiceTest {
    @Mock
    private QuestionService questionService;
    @InjectMocks
    private MathQuestionService mathQuestionService;

    private Question question1;
    private Question question2;
    private Question question3;
    private MathQuestionService questions;

    @BeforeEach
    public void setUp() {
        question1 = new Question("2+2", "4");
        question2 = new Question("3*3", "9");
        question3 = new Question("6-4", "2");

        questions = new MathQuestionService(questions);
        questions.add(question1);
        questions.add(question2);
        questions.add(question3);
    }

    @Test
    void shouldAddNewQuestion() {
        // given
        Question expected = questions.add("4", "4");
        Question actual = new Question("4", "4");
    }

    @Test
    void testAdd() {
    }

    @Test
    void remove() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getRandomQuestion() {
    }
}