drop schema if exists course cascade;

create schema course;

create table course.courses (
course_id TEXT PRIMARY KEY,
name TEXT NOT NULL,
category TEXT NOT NULL,
status TEXT NOT NULL,
created_at TIMESTAMP NOT NULL,
updated_at TIMESTAMP NOT NULL
);