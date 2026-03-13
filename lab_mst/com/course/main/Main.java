package com.course.main;

import com.course.exceptions.*;
import com.course.model.*;
import com.course.services.*;

public class Main {

    public static void main(String[] args) {

        CourseService service = new CourseService();

        Course c1 = new Course(101, "Java Programming", 2);
        Course c2 = new Course(102, "Data Structures", 2);

        service.addCourse(c1);
        service.addCourse(c2);

        Student s1 = new Student(1, "Pratik");
        Student s2 = new Student(2, "Rahul");
        Student s3 = new Student(3, "Aman");

        try {

            service.enrollStudent(101, s1);
            service.enrollStudent(101, s2);

            // This should trigger CourseFullException
            service.enrollStudent(101, s3);

        }
        catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
        catch (CourseFullException e) {
            System.out.println(e.getMessage());
        }
        catch (DuplicateEnrollmentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nCourse Details:");
        service.displayCourseDetails();

        System.out.println("\nFile Records:");
        service.viewCourses();
    }
}