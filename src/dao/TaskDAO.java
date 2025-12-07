package dao;

import database.ConnectionFactory;
import model.Task;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public class TaskDAO implements ITaskDAO{
    @Override
    public int save(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (task_title, task_description, started_at, task_status)  VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            Timestamp startedAt = Timestamp.valueOf(task.getStartedAt());
            ps.setString(1, task.getTaskTitle());
            ps.setString(2, task.getTaskDescription());
            ps.setTimestamp(3, startedAt);
            ps.setString(4, task.getTaskStatus().toString());

            return ps.executeUpdate();
        }
    }

    @Override
    public int updateById(int idTask) {
        return 0;
    }

    @Override
    public List<Task> findAll() {
        return List.of();
    }

    @Override
    public Task findById(int idTask) {
        return null;
    }

    @Override
    public int removeById(int idTask) {
        return 0;
    }

    @Override
    public int completeTaskById(int idTask) {
        return 0;
    }
}
