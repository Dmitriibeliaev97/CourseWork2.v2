package cw.coursework2v2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class TooManyQuestionsException extends Exception {
    public TooManyQuestionsException() {
    }
}
