import utils.TaskManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getTaskManager();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Task Management System");
        String dash = "---------------------------------------------------";
        final String menu = "0. Exit Task Management System.\n1. Add new task\n2. Search a Task\n3. Update task status\n4. Delete a task\n5. Traverse tasks";
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
                    taskManager.addTask();
                    break;
                case 2:
                    taskManager.searchTask();
                    break;
                case 3:
                    taskManager.changeTaskStatus();
                    break;
                case 4:
                    taskManager.deleteTask();
                    break;
                case 5:
                    taskManager.traverseTask();
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