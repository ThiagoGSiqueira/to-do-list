package app.util;

import app.enums.TaskStatus;
import app.model.Task;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class TaskMapper {

    public static Task mapToTask(ResultSet rs) throws SQLException {
        Task task = null;

        Timestamp completedAtTimestamp = rs.getTimestamp("completed_at");
        LocalDateTime completedAt = null;
        if (completedAtTimestamp != null) {
            completedAt = completedAtTimestamp.toLocalDateTime();
        }

        task = new Task(
                rs.getInt("task_id"),
                rs.getString("task_title"),
                rs.getString("task_description"),
                rs.getTimestamp("started_at").toLocalDateTime(),
                TaskStatus.valueOf(rs.getString("task_status").toUpperCase()),
                completedAt
        );

        return task;
    }
}
