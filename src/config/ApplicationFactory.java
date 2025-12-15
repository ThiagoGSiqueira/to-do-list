package config;

import controller.TaskCommandHandler;
import controller.TaskController;
import dao.ITaskDAO;
import dao.TaskDAO;
import service.TaskService;
import service.TaskValidatorService;

public class ApplicationFactory {
    public void runApplication() {
        ITaskDAO taskDAO = new TaskDAO();
        TaskValidatorService taskValidator = new TaskValidatorService();
        TaskService taskService = new TaskService(taskDAO, taskValidator);
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskService);
        TaskController taskController = new TaskController(taskCommandHandler);

        taskController.run();
    }
}
