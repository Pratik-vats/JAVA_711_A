package com.course.model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private int courseid;
    private String coursename;
    private int maxseats;
    private List<Student> enrolledstudents;

    public Course(int courseid , String coursename , int maxseats ){
        this.courseid = courseid;
        this.coursename = coursename;
        this.maxseats = maxseats;
        this.enrolledstudents = new ArrayList<>();
    }

    public int getcourseid(){
        return courseid;
    }
    public String getcoursename(){
        return coursename;
    }
    public int getmaxseats(){
        return maxseats;
    }
    public List<Student> getenrolledstudents() {
        return enrolledstudents;
    }
    public void addstudent(Student s) {
        enrolledstudents.add(s);
    }

    public void display(){
        System.out.println("Course name is : "+ coursename);
        System.out.println("Course ID is : "+ courseid);
        System.out.println("Maxseats is : "+ maxseats);
        System.out.println("No. of Enrolledstudents are : "+ enrolledstudents);
    }
}
