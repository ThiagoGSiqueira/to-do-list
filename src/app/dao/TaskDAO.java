package app.dao;

import app.database.ConnectionFactory;
import app.exceptions.DataAcessException;
import app.model.Task;
import app.util.TaskMapper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDAO implements ITaskDAO {

    @Override
    public int save(Task task) {
        String sql = "INSERT INTO tasks (task_title, task_description, started_at, task_status)  VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            Timestamp startedAt = Timestamp.valueOf(task.getStartedAt());
            ps.setString(1, task.getTaskTitle());
            ps.setString(2, task.getTaskDescription());
            ps.setTimestamp(3, startedAt);
            ps.setString(4, task.getTaskStatus().toString());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();

            if(rs.next()) {
                task.setIdTask(rs.getInt(1));
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new DataAcessException("Erro ao criar a tarefa! ", e);
        }
    }

    @Override
    public int updateById(int idTask, Task task) {
        String sql = "UPDATE tasks SET task_title=?, task_description=? WHERE task_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, task.getTaskTitle());
            ps.setString(2, task.getTaskDescription());
            ps.setInt(3, idTask);

            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataAcessException("Erro ao atualizar a tarefa! ", e);
        }
    }

    @Override
    public List<Task> findAll() {
        String sql = "SELECT * FROM tasks";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            List<Task> tasks = new ArrayList<>();

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tasks.add(TaskMapper.mapToTask(rs));
            }

            return tasks;
        } catch (SQLException e) {
            throw new DataAcessException("Erro ao buscar tarefas!" + e);
        }
    }

    @Override
    public Task findById(int idTask) {
        String sql = "SELECT * FROM tasks WHERE task_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            Task task = null;
            ps.setInt(1, idTask);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                task = TaskMapper.mapToTask(rs);
            }
            return task;

        } catch (SQLException e) {
            throw new DataAcessException("Erro ao buscar tarefa de id: " + idTask + " " + e);
        }
    }

    @Override
    public int removeById(int idTask) {
        String sql = "DELETE FROM tasks WHERE task_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTask);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataAcessException("Erro ao excluir a tarefa! " + e);
        }
    }

    @Override
    public int completeTaskById(int idTask) {
        String sql = "UPDATE tasks SET task_status='Done', completed_at=NOW() WHERE task_id=?";

        try (Connection conn = ConnectionFactory.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idTask);
            return ps.executeUpdate();
        } catch (SQLException e) {
            throw new DataAcessException("Erro ao completar tarefa! " + e);
        }
    }
}
