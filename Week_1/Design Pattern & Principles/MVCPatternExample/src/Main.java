import controllers.StudentController;
import models.Student;
import view.StudentView;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        StudentController studentController = StudentController.getStudentController();
        System.out.println("*** Enter student details ***");
        studentController.createStudent(student);
        StudentView.displayStudentDetails(student);
        studentController.updateStudentName(student);
        StudentView.displayStudentDetails(student);
    }
}