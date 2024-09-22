package br.com.crud_cursos.domain.vo;

import br.com.crud_cursos.domain.entity.Course;

public class CourseStatusFactory {
  public static CourseStatus create(Course course, String status) {
    if(status.equals("activated")) return new ActivatedStatus(course);
    if(status.equals("deactivated")) return new DeactivatedStatus(course);
    throw new RuntimeException("Invalid status");
  }
}
