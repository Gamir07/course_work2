package pro.sky.java.course2.examinerservice.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceededLimitOfQuestionsException extends RuntimeException {
    public ExceededLimitOfQuestionsException() {
    }

    public ExceededLimitOfQuestionsException(String message) {
        super(message);
    }

    public ExceededLimitOfQuestionsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExceededLimitOfQuestionsException(Throwable cause) {
        super(cause);
    }

    public ExceededLimitOfQuestionsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
