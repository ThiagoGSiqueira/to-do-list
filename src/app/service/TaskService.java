package app.service;

import app.dao.ITaskDAO;
import app.model.Task;

import java.util.List;

public class TaskService {

    private final ITaskDAO taskDAO;
    private final TaskValidatorService taskValidator;

    public TaskService(ITaskDAO taskDAO, TaskValidatorService taskValidator) {
        this.taskDAO = taskDAO;
        this.taskValidator = taskValidator;
    }

    public void createTask(Task task) {
        taskValidator.validateEmptyData(task);
        taskValidator.validateTitle(task);
        taskDAO.save(task);
    }

    public void updateTaskById(int idTask, Task task) {
        taskValidator.validateEmptyData(task);
        taskValidator.validateTitle(task);
        taskDAO.updateById(idTask, task);
    }

    public List<Task> findAll() {
        List<Task> tasks = taskDAO.findAll();
        taskValidator.validateEmptyList(tasks);
        return tasks;
    }

    public Task findById(int idTask) {
        Task task = taskDAO.findById(idTask);
        taskValidator.validateTaskNotFound(task);
        return task;
    }

    public void removeTaskById(int idTask) {
        this.findById(idTask);
        taskDAO.removeById(idTask);
    }

    public void completeTaskById(int idTask) {
        Task task = this.findById(idTask);
        taskValidator.validateTaskAlreadyDone(task);
        taskDAO.completeTaskById(idTask);
    }
}
