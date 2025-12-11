import controller.TaskController;

import dao.ITaskDAO;
import dao.TaskDAO;
import service.TaskService;


import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ITaskDAO taskDAO = new TaskDAO();
        TaskController taskController = new TaskController(new TaskService(taskDAO));
        taskController.run();
    }
}