package br.com.crud_cursos.domain.entity;

import br.com.crud_cursos.domain.vo.CourseStatus;
import br.com.crud_cursos.domain.vo.CourseStatusFactory;

import java.time.LocalDateTime;
import java.util.UUID;

public class Course {
  public final String courseId;
  private String name;
  private String category;
  public CourseStatus status;
  private final LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public Course(String courseId, String name, String category, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
    this.courseId = courseId;
    this.name = name;
    this.category = category;
    this.status = CourseStatusFactory.create(this, status);
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
  }

  public Course(String name, String category, String status) {
    this.courseId = UUID.randomUUID().toString();
    this.name = name;
    this.category = category;
    this.status = CourseStatusFactory.create(this, status);
    this.createdAt = LocalDateTime.now();
    this.updatedAt = LocalDateTime.now();
  }

  public void activated() {
    this.status.activated();
  }

  public void deactivated() {
    this.status.deactivated();
  }

  private void update() {
    this.updatedAt = LocalDateTime.now();
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
    this.update();
  }

  public String getCategory() {
    return  this.category;
  }

  public void setCategory(String category) {
    this.category = category;
    this.update();
  }

  public String getStatus() {
    return this.status.getValue();
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }


  public LocalDateTime getUpdatedAt() {
    return this.updatedAt;
  }
}
