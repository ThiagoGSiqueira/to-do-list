package app.config;

import app.controller.TaskCommandHandler;
import app.controller.TaskController;
import app.dao.ITaskDAO;
import app.ports.ITaskDetailsView;
import app.ports.ITaskListView;
import app.ports.IOutputMessage;
import app.service.TaskService;
import app.service.TaskValidatorService;
import app.view.TaskDetailsView;
import app.view.TaskListView;
import app.view.feedback.ConsoleView;

public class ApplicationFactory {
    public void runApplication(ITaskDAO taskDAO) {
        TaskValidatorService taskValidator = new TaskValidatorService();
        TaskService taskService = new TaskService(taskDAO, taskValidator);
        IOutputMessage outputMessage = new ConsoleView();
        ITaskListView listAllTasks = new TaskListView();
        ITaskDetailsView taskDetailsView = new TaskDetailsView();
        TaskCommandHandler taskCommandHandler = new TaskCommandHandler(taskService, outputMessage, listAllTasks, taskDetailsView);
        TaskController taskController = new TaskController(taskCommandHandler);

        taskController.run();
    }
}
