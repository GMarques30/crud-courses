package br.com.crud_cursos.domain.vo;

import br.com.crud_cursos.domain.entity.Course;

public class ActivatedStatus extends CourseStatus{

  public ActivatedStatus(Course course) {
    super(course);
    this.value = "activated";
  }

  @Override
  public void activated() throws IllegalArgumentException {
    throw new IllegalArgumentException("Invalid status");
  }

  @Override
  public void deactivated() {
    this.course.status = new DeactivatedStatus(this.course);
  }

  @Override
  public String getValue() {
    return this.value;
  }
}
