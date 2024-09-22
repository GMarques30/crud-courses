package br.com.crud_cursos.application.dto;

import java.time.LocalDateTime;

public record ListCoursesOutput(String courseId, String name, String category, String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
