import manager.EmployeeManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeManager employeeManager = EmployeeManager.getEmployeeManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Employee Management System");
        String dash = "---------------------------------------------------";
        final String menu = "0. Exit Task Management System.\n1. Add new employee\n2. Search Employee by name\n3. Search Employee by Id\n4. Delete an Employee\n5. Traverse all employee";
        while (true){
            System.out.println(dash);
            System.out.println("*** Menu ***");
            System.out.println(dash);
            System.out.println(menu);
            System.out.println(dash);
            System.out.print("Choose One Option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    break;
                case 1:
                    employeeManager.addEmployee();
                    break;
                case 2:
                    employeeManager.searchEmployeeByName();
                    break;
                case 3:
                    employeeManager.searchEmployeeById();
                    break;
                case 4:
                    employeeManager.deleteEmployee();
                    break;
                case 5:
                    employeeManager.traverseEmployeeList();
                    break;
                default:
                    System.out.println("Choose correct options");
                    break;
            }
            if (choice == 0){
                System.out.println("Bye!");
                break;
            }
        }
    }
}