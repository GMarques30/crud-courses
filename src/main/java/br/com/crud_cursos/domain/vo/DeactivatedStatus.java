package br.com.crud_cursos.domain.vo;

import br.com.crud_cursos.domain.entity.Course;

public class DeactivatedStatus extends CourseStatus {

  public DeactivatedStatus(Course course) {
    super(course);
    this.value = "deactivated";
  }

  @Override
  public void activated() {
    this.course.status = new ActivatedStatus(this.course);
  }

  @Override
  public void deactivated() throws IllegalArgumentException {
    throw new IllegalArgumentException("Invalid status");
  }

  @Override
  public String getValue() {
    return this.value;
  }
}
