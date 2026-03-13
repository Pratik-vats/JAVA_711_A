package com.course.model;

public class Student {
    private int studentid;
    private String studentname;

    public Student(int studentid , String studentname){
        this.studentid = studentid;
        this.studentname = studentname;
    }

    public int getstudentid(){
        return studentid;
    }
    public String getstudentname(){
        return studentname;
    }
    public void display(){
        System.out.println("Student id is : " + studentid);
        System.out.println("Student name is : " + studentname);
    }
}
