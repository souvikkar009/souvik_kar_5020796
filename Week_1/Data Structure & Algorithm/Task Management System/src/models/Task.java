package models;

public class Task {
    private int taskId;
    private String taskName;
    private Status status;

    public Task() {
    }

    public Task(int taskId, String taskName, Status status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId = " + taskId +
                ", taskName = '" + taskName + '\'' +
                ", status = " + status +
                '}';
    }
}
