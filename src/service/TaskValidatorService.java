package service;

import exceptions.EmptyDataException;
import exceptions.TitleTooLongException;
import model.Task;

public class TaskValidatorService {
    public void validate(Task task) {
        if (task.getTaskTitle().length() > 30) {
            throw new TitleTooLongException("Título muito longo.");
        }
        if (task.getTaskTitle().isEmpty() || task.getTaskDescription().isEmpty()) {
            throw new EmptyDataException("Campos vazios");
        }
    }
}
