package dao;

import model.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskDAO {
    int save(Task task) throws SQLException;
    int updateById(int idTask);
    List<Task> findAll();
    Task findById(int idTask);
    int removeById(int idTask);
    int completeTaskById(int idTask);
}
