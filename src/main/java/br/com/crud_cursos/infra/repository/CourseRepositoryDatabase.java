package br.com.crud_cursos.infra.repository;

import br.com.crud_cursos.application.repository.CourseRepository;
import br.com.crud_cursos.domain.entity.Course;
import br.com.crud_cursos.infra.database.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseRepositoryDatabase implements CourseRepository {
  @Autowired
  private final DatabaseConnection connection;

  public CourseRepositoryDatabase(DatabaseConnection connection) {
    this.connection = connection;
  }

  @Override
  public List<Course> listCourses() {
    List<Course> courses = new ArrayList<>();
    String stmt = "SELECT * FROM course.courses";
    ResultSet rs = this.connection.query(stmt);
    try {
      while (rs.next()) {
        Course course = new Course(rs.getString("course_id"), rs.getString("name"), rs.getString("category"), rs.getString("status"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());
        courses.add(course);
      }
      return courses;
    } catch (SQLException err) {
      throw new RuntimeException("Error executing the query", err);
    }
  }

  @Override
  public Course findByName(String name) {
    String stmt = "SELECT * FROM course.courses WHERE name = ?";
    try {
      ResultSet rs = this.connection.query(stmt, new Object[]{name});
      if (rs.next()) {
        return new Course(rs.getString("course_id"), rs.getString("name"), rs.getString("category"), rs.getString("status"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());
      }
      return null;
    } catch (SQLException err) {
      throw new RuntimeException("Error executing the query", err);
    }
  }

  @Override
  public Course findById(String courseId) {
    String stmt = "SELECT * FROM course.courses WHERE course_id = ?";
    ResultSet rs = this.connection.query(stmt, new Object[]{courseId});
    try {
      if (rs.next()) {
        return new Course(rs.getString("course_id"), rs.getString("name"), rs.getString("category"), rs.getString("status"), rs.getTimestamp("created_at").toLocalDateTime(), rs.getTimestamp("updated_at").toLocalDateTime());
      }
      return null;
    } catch (SQLException err) {
      throw new RuntimeException("Error executing the query", err);
    }
  }

  @Override
  public void create(Course course) {
    String stmt = "INSERT INTO course.courses (course_id, name, category, status, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
    this.connection.command(stmt, new Object[]{course.courseId, course.getName(), course.getCategory(), course.getStatus(), course.getCreatedAt(), course.getUpdatedAt()});
  }

  @Override
  public void update(Course course) {
    String stmt = "UPDATE course.courses SET name = ?, category = ?, status = ?, created_at = ?, updated_at = ? WHERE course_id = ?";
    this.connection.command(stmt, new Object[]{course.getName(), course.getCategory(), course.getStatus(), course.getCreatedAt(), course.getUpdatedAt(), course.courseId});
  }

  @Override
  public void remove(String courseId) {
    String stmt = "DELETE FROM course.courses WHERE course_id = ?";
    this.connection.command(stmt, new Object[]{courseId});
  }
}
