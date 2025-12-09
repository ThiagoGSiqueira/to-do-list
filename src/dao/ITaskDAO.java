package dao;

import model.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskDAO {
    int save(Task task);
    int updateById(int idTask, Task task);
    List<Task> findAll();
    Task findById(int idTask);
    int removeById(int idTask);
    int completeTaskById(int idTask);
}
