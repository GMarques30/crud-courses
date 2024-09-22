package br.com.crud_cursos.infra.http;

import br.com.crud_cursos.application.dto.*;
import br.com.crud_cursos.application.usecase.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
  @Autowired
  private final CreateCourse createCourse;
  @Autowired
  private final RemoveCourse removeCourse;
  @Autowired
  private final UpdateCourse updateCourse;
  @Autowired
  private final ListCourses listCourses;
  @Autowired
  private final ActiveCourse activeCourse;

  public CourseController(CreateCourse createCourse, RemoveCourse removeCourse, UpdateCourse updateCourse, ListCourses listCourses, ActiveCourse activeCourse) {
    this.createCourse = createCourse;
    this.removeCourse = removeCourse;
    this.updateCourse = updateCourse;
    this.listCourses = listCourses;
    this.activeCourse = activeCourse;
  }

  @PostMapping
  public ResponseEntity<CreateCourseOutput> createCourse(@RequestBody CreateCourseInput input) {
    try {
      CreateCourseOutput output = this.createCourse.execute(input);
      return ResponseEntity.ok(output);
    } catch (Exception err) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage(), err);
    }
  }

  @DeleteMapping("/{courseId}")
  public ResponseEntity<Void> removeCourse(@PathVariable("courseId") RemoveCourseInput input) {
    try {
      this.removeCourse.execute(input);
      return ResponseEntity.noContent().build();
    } catch (Exception err) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage(), err);
    }
  }

  @PutMapping
  public ResponseEntity<Void> updateCourse(@RequestBody UpdateCourseInput input) {
    try {
      this.updateCourse.execute(input);
      return ResponseEntity.noContent().build();
    } catch (Exception err) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage(), err);
    }
  }

  @PatchMapping("/{courseId}/active")
  public ResponseEntity<Void> activeCourse(@PathVariable("courseId") ActiveCourseInput input) {
    try {
      this.activeCourse.execute(input);
      return ResponseEntity.noContent().build();
    } catch(Exception err) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, err.getMessage(), err);
    }
  }

  @GetMapping
  public ResponseEntity<List<ListCoursesOutput>> listCourses() {
    try {
      return ResponseEntity.ok().body(this.listCourses.execute());
    } catch (Exception err) {
      throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, err.getMessage(), err);
    }
  }
}
