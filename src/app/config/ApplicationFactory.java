package app.config;

import app.controller.TaskCommandHandler;
import app.controller.TaskController;
import app.dao.ITaskDAO;
import app.service.TaskService;
import app.service.TaskValidatorService;

public class ApplicationFactory {
    public void runApplication(ITaskDAO taskDAO) {
        TaskValidatorService taskValidator = new TaskValidatorService();
        TaskService taskService = new TaskService(taskDAO, taskValidator);
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskService);
        TaskController taskController = new TaskController(taskCommandHandler);

        taskController.run();
    }
}
