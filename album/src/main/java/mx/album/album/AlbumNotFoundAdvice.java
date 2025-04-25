package mx.album.album;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AlbumNotFoundAdvice {

    @ExceptionHandler(AlbumNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(AlbumNotFoundException ex) {
        return ex.getMessage();
    }
}
