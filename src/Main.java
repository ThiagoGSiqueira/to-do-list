import dao.ITaskDAO;
import dao.TaskDAO;
import model.Task;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        ITaskDAO taskDAO = new TaskDAO();

        taskDAO.completeTaskById(1);
    }
}