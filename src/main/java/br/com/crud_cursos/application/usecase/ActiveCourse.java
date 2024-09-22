package br.com.crud_cursos.application.usecase;

import br.com.crud_cursos.application.dto.ActiveCourseInput;
import br.com.crud_cursos.application.exception.NotFoundCourseException;
import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActiveCourse {
  @Autowired
  private final CourseRepository courseRepository;

  public ActiveCourse(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public void execute(ActiveCourseInput input) {
    Course course = this.courseRepository.findById(input.courseId());
    if(course == null) {
      throw new NotFoundCourseException("Course not found");
    }
    if(course.getStatus().equals("activated")) {
      course.deactivated();
    } else {
      course.activated();
    }
    this.courseRepository.update(course);
  }
}
