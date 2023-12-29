package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.java.course2.examinerservice.domain.Question;
import pro.sky.java.course2.examinerservice.exceptions.ExceededLimitOfQuestionsException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    private final Question QUESTION1 = new Question("MoneyOrLife", "Life");
    private final Question QUESTION2 = new Question("MercedesOrBMW", "BMW");
    private final Set<Question> QUESTIONS = new HashSet<>(Set.of(
            new Question("MoneyOrLife", "Life"),
            new Question("javaOrPython", "java"),
            new Question("MercedesOrBMW", "BMW"),
            new Question("coffeeOrTea", "coffee")));

    @InjectMocks
    ExaminerServiceImpl out;

    @Mock
    JavaQuestionService questionService;

    @BeforeEach
    void setUp() {
        Mockito.when(questionService.getAll()).thenReturn(QUESTIONS);

    }

    @Test
    void methodShouldThrowExceededLimitOfQuestionsException() {
        assertThrows(ExceededLimitOfQuestionsException.class, () -> out.getQuestions(5));
    }

    @Test
    void shouldReturnRandomQuestions() {
        Mockito.when(questionService.getRandomQuestion()).thenReturn(QUESTION1,QUESTION2);
        Collection<Question> actual = out.getQuestions(2);
        assertEquals(2, actual.size());
    }
}