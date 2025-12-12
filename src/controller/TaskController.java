package controller;

import enums.TaskOptions;
import exceptions.DataAcessException;
import model.Task;
import service.TaskService;
import view.*;

import java.util.List;

public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void run() {

        boolean running = true;

        while (running) {
            MenuView menuView = new MenuView();
            TaskOptions taskOptions = menuView.render();

            switch (taskOptions) {
                case CREATE_TASK -> handleCreateTask();
                case UPDATE_TASK -> handleUpdateTask();
                case FIND_ALL_TASKS -> handleFindAll();
                case FIND_TASK_BY_ID -> handleFindTaskById();
                case REMOVE_TASK -> handleRemoveTaskById();
                case COMPLETE_TASK -> handleCompleteTaskById();
                case EXIT -> running = false;
                case INVALID_OPTION -> {
                }
            }
        }
    }

    private void handleCreateTask() {
        TaskFormView taskFormView = new TaskFormView();
        Task task = taskFormView.render();
        taskService.createTask(task);
    }

    private void handleUpdateTask() {

        TaskFormView taskFormView = new TaskFormView();
        IdInputView idInputView = new IdInputView();
        int idTask = idInputView.getTaskId();
        Task task = taskFormView.render();

        taskService.updateTaskById(idTask, task);

    }

    public void handleFindAll() {
        ListAllTasksView listAllTasksView = new ListAllTasksView();
        List<Task> tasks = taskService.findAll();
        listAllTasksView.render(tasks);
    }

    public void handleFindTaskById() {
        TaskDetailsView taskDetailsView = new TaskDetailsView();
        IdInputView idInputView = new IdInputView();
        int idTask = idInputView.getTaskId();
        Task task = taskService.findById(idTask);
        taskDetailsView.render(task);
    }

    public void handleRemoveTaskById() {
        IdInputView idInputView = new IdInputView();
        int idTask = idInputView.getTaskId();
        taskService.removeTaskById(idTask);
    }

    public void handleCompleteTaskById() {
        IdInputView idInputView = new IdInputView();
        int idTask = idInputView.getTaskId();
        taskService.completeTaskById(idTask);
    }
}
