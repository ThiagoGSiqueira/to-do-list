package controller;

import enums.TaskOptions;
import model.Task;
import service.TaskService;
import view.IdInputView;
import view.MenuView;
import view.TaskFormView;

public class TaskController {

    TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public void run() {
        MenuView menuView = new MenuView();
        TaskOptions taskOptions = menuView.run();

        switch (taskOptions) {
            case CREATE_TASK -> handleCreateTask();
            case UPDATE_TASK -> handleUpdateTask();
        }

    }

    private void handleCreateTask(){
        TaskFormView taskFormView = new TaskFormView();
        Task task = taskFormView.render();
        taskService.createTask(task);
    }

    private void handleUpdateTask(){
        TaskFormView taskFormView = new TaskFormView();
        IdInputView idInputView = new IdInputView();
        int idTask = idInputView.getTaskId();
        Task task = taskFormView.render();

        taskService.updateTaskById(idTask, task);
    }

}
