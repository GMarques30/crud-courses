package br.com.crud_cursos.application.usecase;

import br.com.crud_cursos.application.dto.UpdateCourseInput;
import br.com.crud_cursos.application.exception.NotFoundCourseException;
import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourse {

  @Autowired
  private final CourseRepository courseRepository;

  public UpdateCourse(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public void execute(UpdateCourseInput input) {
    Course course = this.courseRepository.findById(input.courseId());
    if(course == null) {
      throw new NotFoundCourseException("Course not found");
    }
    if(input.name() != null) {
      course.setName(input.name());
    }
    if(input.category() != null) {
      course.setCategory(input.category());
    }
    this.courseRepository.update(course);
  }
}
