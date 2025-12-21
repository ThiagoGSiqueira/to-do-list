package app.controller;

import app.enums.TaskOptions;
import app.util.ViewUtils;
import app.view.*;

import javax.swing.text.View;

public class TaskController {

    private final TaskCommandHandler taskCommandHandler;

    public TaskController(TaskCommandHandler taskCommandHandler) {
        this.taskCommandHandler = taskCommandHandler;
    }

    public void run() {

        boolean running = true;

        while (running) {
            MenuView menuView = new MenuView();
            TaskOptions taskOptions = menuView.render();

            switch (taskOptions) {
                case CREATE_TASK -> taskCommandHandler.handleCreateTask();
                case UPDATE_TASK -> taskCommandHandler.handleUpdateTask();
                case FIND_ALL_TASKS -> taskCommandHandler.handleFindAll();
                case FIND_TASK_BY_ID -> taskCommandHandler.handleFindTaskById();
                case REMOVE_TASK -> taskCommandHandler.handleRemoveTaskById();
                case COMPLETE_TASK -> taskCommandHandler.handleCompleteTaskById();
                case EXIT -> running = false;
                case INVALID_OPTION -> {
                }
            }
        }
    }

}
