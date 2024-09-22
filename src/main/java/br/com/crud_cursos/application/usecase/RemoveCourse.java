package br.com.crud_cursos.application.usecase;

import br.com.crud_cursos.application.dto.RemoveCourseInput;
import br.com.crud_cursos.application.exception.NotFoundCourseException;
import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RemoveCourse {

  @Autowired
  private final CourseRepository courseRepository;

  public RemoveCourse(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public void execute(RemoveCourseInput input) {
    Course course = this.courseRepository.findById(input.courseId());
    if(course == null) {
      throw new NotFoundCourseException("Course not found");
    }
    this.courseRepository.remove(input.courseId());
  }
}
