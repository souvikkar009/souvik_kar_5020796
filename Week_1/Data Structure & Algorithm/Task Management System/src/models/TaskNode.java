package models;

public class TaskNode {
    private Task task;
    private TaskNode nextTaskNode;

    public TaskNode() {
    }

    public TaskNode(Task task) {
        this.task = task;
        this.nextTaskNode = null;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public TaskNode getNextTaskNode() {
        return nextTaskNode;
    }

    public void setNextTaskNode(TaskNode nextTaskNode) {
        this.nextTaskNode = nextTaskNode;
    }
}
