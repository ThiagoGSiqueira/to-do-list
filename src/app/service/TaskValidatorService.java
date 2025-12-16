package app.service;

import app.enums.TaskStatus;
import app.exceptions.*;
import app.model.Task;

import java.util.List;

public class TaskValidatorService {
    public void validateEmptyData(Task task) {
        if (task.getTaskTitle().isEmpty() || task.getTaskDescription().isEmpty()) {
            throw new EmptyDataException("Campos vazios");
        }
    }

    public void validateTitle(Task task) {
        if (task.getTaskTitle().length() > 30) {
            throw new TitleTooLongException("Título muito longo.");
        }
    }

    public void validateEmptyList(List<Task> tasks) {
        if (tasks.isEmpty()) {
            throw new EmptyListException("Nenhuma tarefa encontrada");
        }
    }

    public void validateTaskNotFound(Task task) {
        if (task ==  null) {
            throw new TaskNotFoundException("Tarefa não encontrada");
        }
    }

    public void validateTaskAlreadyDone(Task task) {
        if(task.getTaskStatus().equals(TaskStatus.DONE)) {
            throw new TaskAlreadyDoneException("Tarefa já concluida");
        };
    }
}
