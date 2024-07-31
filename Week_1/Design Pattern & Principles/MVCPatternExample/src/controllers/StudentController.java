package controllers;

import models.Student;

import java.util.Scanner;

public class StudentController {
    private final Scanner sc = new Scanner(System.in);
    private static StudentController studentController = null;
    private StudentController() {
    }
    public static StudentController getStudentController(){
        if (studentController == null){
            studentController = new StudentController();
        }
        return studentController;
    }
    public void createStudent(Student student){
        System.out.println("Enter student name:");
        student.setName(sc.nextLine());
        System.out.println("Enter student id:");
        student.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter student grade:");
        student.setGrade(sc.nextLine());
        System.out.println("Student details uploaded");
    }
    public void updateStudentName(Student student){
        System.out.println("Enter student name:");
        student.setName(sc.nextLine());
        System.out.println("Student name uploaded");
    }
    public void updateStudentId(Student student){
        System.out.println("Enter student id:");
        student.setId(sc.nextInt());
        sc.nextLine();
        System.out.println("Student id updated");
    }
    public void updateStudentGrade(Student student){
        System.out.println("Enter student grade:");
        student.setGrade(sc.nextLine());
        System.out.println("Student grade uploaded");
    }

}
