package br.com.crud_cursos.application.repository;

import br.com.crud_cursos.domain.entity.Course;

import java.util.List;
import java.util.UUID;

public interface CourseRepository {
  List<Course> listCourses();
  Course findByName(String name);
  Course findById(String courseId);
  void create(Course course);
  void update(Course course);
  void remove(String courseId);
}
