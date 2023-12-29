package pro.sky.java.course2.examinerservice.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pro.sky.java.course2.examinerservice.domain.Question;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    private JavaQuestionService out;


    @BeforeEach
    void setUp() {
        out = new JavaQuestionService();
    }


    @ParameterizedTest
    @CsvSource(value = {"coffeeOrTea, coffee", "age,32", "cellar, iPhone"})
    void shouldAddQuestionSuccessfullyWithTwoParameters(String question, String answer) {
        out.add(question, answer);
        assertTrue(out.getAll().contains(new Question(question, answer)));
    }

    @Test
    void shouldAddQuestionSuccessfullyWithOneParameter() {
        Question question = new Question("team", "Barcelona");
        out.add(question);
        assertTrue(out.getAll().contains(question));
    }

    @Test
    void shouldRemoveQuestionSuccessfully() {
        Question question = new Question("winterOrSummer", "winter");
        out.add(question);
        out.remove(question);
        assertFalse(out.getAll().contains(question));
    }

    @Test
    void shouldReturnAllTheQuestions() {
        Set<Question> expected = new HashSet<>(Set.of(
                new Question("dayOrNight", "day"),
                new Question("sunOrMoon", "sun"),
                new Question("javaOrPython", "java")));
        out.add("dayOrNight", "day");
        out.add("sunOrMoon", "sun");
        out.add("javaOrPython", "java");
        assertIterableEquals(expected, out.getAll());
    }

}