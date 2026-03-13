package com.course.services;

import com.course.model.Course;
import com.course.model.Student;
import com.course.exceptions.*;

import java.io.*;
import java.util.*;

public class CourseService {

    private List<Course> courses = new ArrayList<>();

    public void addCourse(Course c) {
        courses.add(c);
    }

    public void enrollStudent(int courseId, Student s)
            throws CourseNotFoundException, CourseFullException, DuplicateEnrollmentException {

        Course course = null;

        for (Course c : courses) {
            if (c.getcourseid() == courseId) {
                course = c;
                break;
            }
        }

        if (course == null) {
            throw new CourseNotFoundException("Course not found");
        }

        if (course.getenrolledstudents().size() >= course.getmaxseats()) {
            throw new CourseFullException("Course is full");
        }

        for (Student st : course.getenrolledstudents()) {
            if (st.getstudentid() == s.getstudentid()) {
                throw new DuplicateEnrollmentException("Student already enrolled");
            }
        }

        course.addstudent(s);

        saveEnrollment(course, s);
    }

    private void saveEnrollment(Course course, Student student) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("courses.txt", true))) {

            bw.write(course.getcourseid() + "," +
                    course.getcoursename() + "," +
                    student.getstudentid() + "," +
                    student.getstudentname());

            bw.newLine();

        } catch (IOException e) {
            System.out.println("File writing error");
        }
    }

    public void viewCourses() {

        try (BufferedReader br = new BufferedReader(new FileReader("courses.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("File reading error");
        }
    }

    public void displayCourseDetails() {

        for (Course c : courses) {
            c.display();
        }
    }
}