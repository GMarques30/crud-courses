package br.com.crud_cursos.application.usecase;

import br.com.crud_cursos.application.dto.CreateCourseInput;
import br.com.crud_cursos.application.dto.CreateCourseOutput;
import br.com.crud_cursos.application.exception.DuplicateCourseException;
import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourse {

  @Autowired
  private final CourseRepository courseRepository;

  public CreateCourse(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public CreateCourseOutput execute(CreateCourseInput input) {
    Course courseExisting = this.courseRepository.findByName(input.name());
    if (courseExisting != null) {
      throw new DuplicateCourseException("Existing course");
    }
    Course course = new Course(input.name(), input.category(), input.status());
    this.courseRepository.create(course);
    return new CreateCourseOutput(course.courseId);
  }
}
