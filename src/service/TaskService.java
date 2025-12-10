package service;

import dao.ITaskDAO;
import model.Task;

import java.util.List;

public class TaskService {

    ITaskDAO taskDAO;

    public TaskService(ITaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public Task createTask(Task task) {
        taskDAO.save(task);
        return task;
    }

    public boolean updateTaskById(int idTask, Task task) {
        return taskDAO.updateById(idTask, task) >= 1;
    }

    public List<Task> findAll() {
        return taskDAO.findAll();
    }

    public Task findById(int idTask) {
        return taskDAO.findById(idTask);
    }

    public boolean removeTaskById(int idTask) {
        return taskDAO.removeById(idTask) >= 1;
    }

    public boolean completeTaskById(int idTask) {
        return taskDAO.completeTaskById(idTask) >= 1;
    }
}
