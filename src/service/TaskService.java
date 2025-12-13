package service;

import dao.ITaskDAO;
import dao.TaskDAO;
import enums.TaskStatus;
import exceptions.*;
import model.Task;

import java.util.List;

public class TaskService {

    ITaskDAO taskDAO;
    TaskValidatorService taskValidator = new TaskValidatorService();
    public TaskService() {
        taskDAO = new TaskDAO();
    }

    public TaskService(ITaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    public void createTask(Task task) {
        taskValidator.validate(task);
        taskDAO.save(task);
    }

    public void updateTaskById(int idTask, Task task) {
        taskValidator.validate(task);

        taskDAO.updateById(idTask, task);
    }

    public List<Task> findAll() {
        List<Task> tasks = taskDAO.findAll();
        if (tasks.isEmpty()) {
            throw new EmptyListException("Nenhuma tarefa encontrada");
        }
        return  tasks;
    }

    public Task findById(int idTask) {
        Task task = taskDAO.findById(idTask);
        if (task ==  null) {
            throw new TaskNotFoundException("Tarefa não encontrada");
        }
        return task;
    }

    public void removeTaskById(int idTask) {
        this.findById(idTask);
        taskDAO.removeById(idTask);
    }

    public void completeTaskById(int idTask) {
        Task task = this.findById(idTask);

        if(task.getTaskStatus().equals(TaskStatus.DONE)) {
            throw new TaskAlreadyDoneException("Tarefa já concluida");
        };
        taskDAO.completeTaskById(idTask);
    }
}
