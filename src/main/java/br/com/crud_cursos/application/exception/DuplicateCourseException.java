package br.com.crud_cursos.application.exception;

public class DuplicateCourseException extends RuntimeException {
  public DuplicateCourseException(String message) {
    super(message);
  }
}
