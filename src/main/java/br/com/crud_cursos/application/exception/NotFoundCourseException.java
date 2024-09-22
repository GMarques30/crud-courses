package br.com.crud_cursos.application.exception;

public class NotFoundCourseException extends RuntimeException {
  public NotFoundCourseException(String message) {
    super(message);
  }
}
