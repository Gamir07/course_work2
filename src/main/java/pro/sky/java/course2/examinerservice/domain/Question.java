package pro.sky.java.course2.examinerservice.domain;

public record Question(String question, String answer) {

    @Override
    public String toString() {
        return "Question{" +
               "question ='" + question + '\'' +
               ", answer ='" + answer + '\'' +
               '}';
    }
}
