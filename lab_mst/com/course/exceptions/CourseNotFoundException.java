package com.course.exceptions;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException(String message) {
        super(message);
    }
}