package test.mock;

import app.dao.ITaskDAO;
import app.enums.TaskStatus;
import app.model.Task;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TaskDAOMock implements ITaskDAO {

    private final List<Task> tasks = new ArrayList<Task>();
    private int nextId = 1;

    @Override
    public int save(Task task) {
        tasks.add(task);
        task.setIdTask(nextId++);
        if (!tasks.isEmpty()) {
            return 1;
        }
        return 0;
    }

    @Override
    public int updateById(int idTask, Task task) {
        for (Task t : tasks) {
            if (t.getIdTask() == idTask) {
                t.setTaskTitle(task.getTaskTitle());
                t.setTaskDescription(task.getTaskDescription());
                return 1;
            }
        }
        return 0;
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Task findById(int idTask) {
        for (Task t : tasks) {
            if (t.getIdTask() == idTask) {
                return t;
            }
        }
        return null;
    }

    @Override
    public int removeById(int idTask) {
        for (Task t : tasks) {
            if (t.getIdTask() == idTask) {
                tasks.remove(t);
                return 1;
            }
        }
        return 0;
    }

    @Override
    public int completeTaskById(int idTask) {
        for (Task t : tasks) {
            if (t.getIdTask() == idTask) {
                t.setTaskStatus(TaskStatus.DONE);
                t.setCompletedAt(LocalDateTime.now());
                return 1;
            }
        }
        return 0;
    }
}

