package br.com.crud_cursos.application.usecase;

import br.com.crud_cursos.application.dto.ListCoursesOutput;
import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCourses {

  @Autowired
  private final CourseRepository courseRepository;

  public ListCourses(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<ListCoursesOutput> execute() {
    List<Course> courses = this.courseRepository.listCourses();
    return courses.stream().map((course ->
      new ListCoursesOutput(course.courseId, course.getName(), course.getCategory(), course.getStatus(), course.getCreatedAt(), course.getUpdatedAt())
    )).toList();
  }
}
