package br.com.crud_cursos.domain.vo;

import br.com.crud_cursos.domain.entity.Course;

public abstract class CourseStatus {
  public String value;
  public final Course course;

  public CourseStatus(Course course) {
    this.course = course;
  }

  public abstract void activated();
  public abstract void deactivated();
  public abstract String getValue();
}
