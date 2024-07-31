package utils;


import models.Status;
import models.Task;
import models.TaskNode;
import services.TaskOps;

import java.util.Scanner;

public class TaskManager implements TaskOps {
    private static TaskManager taskManager = null;
    private static TaskNode taskNode;
    private final Scanner sc = new Scanner(System.in);
    private final String taskStatus =
            "Task status list:\n1. TODO\n2. IN_PROGRESS,\n3. COMPLETED,\n4. ON_HOLD,\n5. CANCELLED,\n6. BACKLOG,\n7. PENDING_REVIEW,\n8. BLOCKED";

    private TaskManager(){
        taskNode = new TaskNode();
    }

    public static TaskManager getTaskManager(){
        if (taskManager == null){
            taskManager = new TaskManager();
        }
        return taskManager;
    }

    @Override
    public void addTask() {
        Task task = createTask();
        if (taskNode.getTask() == null){
            taskNode.setTask(task);
            return;
        }
        TaskNode temp = taskNode;
        TaskNode newTaskNode = new TaskNode(task);
        while (temp.getNextTaskNode() != null){
            temp = temp.getNextTaskNode();
        }
        temp.setNextTaskNode(newTaskNode);
    }

    @Override
    public void searchTask() {
        System.out.println("Enter task name to search: ");
        String taskName = sc.nextLine();
        TaskNode temp = taskNode;
        while (temp != null){
            if(temp.getTask().getTaskName().equals(taskName)){
                System.out.println("Task Found!");
                System.out.println(temp.getTask());
                return;
            }
            temp = temp.getNextTaskNode();
        }
        System.out.println("Task not found");
    }

    @Override
    public void traverseTask() {
        if (taskNode.getTask() == null){
            System.out.println("Empty task list!");
        }
        TaskNode temp = taskNode;
        System.out.println("Task list:");
        while (temp != null){
            System.out.println(temp.getTask());
            temp = temp.getNextTaskNode();
        }
    }

    @Override
    public void deleteTask() {
        System.out.println("Enter task name to delete: ");
        String taskName = sc.nextLine();
        TaskNode temp = taskNode;
        TaskNode temp2 = null;
        while (temp != null){
            if(temp.getTask().getTaskName().equals(taskName)){
                temp2 = temp;
                break;
            }
            temp = temp.getNextTaskNode();
        }
        if (temp2 == null){
            System.out.println("Task not found");
            return;
        }
        if(temp2 == taskNode){
            taskNode = taskNode.getNextTaskNode();
            System.out.println("Task deleted");
            return;
        }
        if (temp2.getNextTaskNode() == null){
            temp2 = taskNode;
            while (temp2.getNextTaskNode() != null && temp2.getNextTaskNode().getNextTaskNode() != null){
                temp2 = temp2.getNextTaskNode();
            }
            temp2.setNextTaskNode(temp2.getNextTaskNode().getNextTaskNode());
            System.out.println("Task deleted");
            return;
        }
        temp2.setTask(temp2.getNextTaskNode().getTask());
        temp2.setNextTaskNode(temp2.getNextTaskNode().getNextTaskNode());
        System.out.println("Task deleted");
    }

    @Override
    public void changeTaskStatus() {
        System.out.println("Enter task name to change status: ");
        String taskName = sc.nextLine();
        TaskNode temp = taskNode;
        TaskNode temp2 = null;
        while (temp != null){
            if(temp.getTask().getTaskName().equals(taskName)){
                temp2 = temp;
                break;
            }
            temp = temp.getNextTaskNode();
        }
        if (temp2 == null){
            System.out.println("Task not found");
            return;
        }
        System.out.println("Choose task status: ");
        System.out.println(taskStatus);
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                temp2.getTask().setStatus(Status.TODO);
                break;
            case 2:
                temp2.getTask().setStatus(Status.IN_PROGRESS);
                break;
            case 3:
                temp2.getTask().setStatus(Status.COMPLETED);
                break;
            case 4:
                temp2.getTask().setStatus(Status.ON_HOLD);
                break;
            case 5:
                temp2.getTask().setStatus(Status.CANCELLED);
                break;
            case 6:
                temp2.getTask().setStatus(Status.BACKLOG);
                break;
            case 7:
                temp2.getTask().setStatus(Status.PENDING_REVIEW);
                break;
            case 8:
                temp2.getTask().setStatus(Status.BLOCKED);
                break;
            default:
                System.out.println("Wrong choice!");
                break;
        }

    }

    private Task createTask(){
        Task task = new Task();
        System.out.println("Enter taskId:");
        task.setTaskId(sc.nextInt());
        sc.nextLine();
        System.out.println("Enter task name:");
        task.setTaskName(sc.nextLine());
        System.out.println(taskStatus);
        System.out.print("Choose task status:");
        int choice = sc.nextInt();
        sc.nextLine();
        switch (choice){
            case 1:
                task.setStatus(Status.TODO);
                break;
            case 2:
                task.setStatus(Status.IN_PROGRESS);
                break;
            case 3:
                task.setStatus(Status.COMPLETED);
                break;
            case 4:
                task.setStatus(Status.ON_HOLD);
                break;
            case 5:
                task.setStatus(Status.CANCELLED);
                break;
            case 6:
                task.setStatus(Status.BACKLOG);
                break;
            case 7:
                task.setStatus(Status.PENDING_REVIEW);
                break;
            case 8:
                task.setStatus(Status.BLOCKED);
                break;
            default:
                task.setStatus(null);
                break;
        }
        return task;
    }
}
