package mx.artista.artista;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ArtistaNotFoundAdvice {
    @ExceptionHandler(ArtistaNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String artistaNotFoundHandler(ArtistaNotFoundException ex) {
    return ex.getMessage();
  }
}
