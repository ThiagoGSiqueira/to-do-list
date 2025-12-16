package app.controller;

import app.exceptions.*;
import app.model.Task;
import app.service.TaskService;
import app.view.IdInputView;
import app.view.ListAllTasksView;
import app.view.TaskDetailsView;
import app.view.TaskFormView;
import app.view.feedback.*;

import java.util.List;

public class TaskCommandHandler {

    private final TaskService taskService;

    public TaskCommandHandler(TaskService taskService) {
        this.taskService = taskService;
    }

    protected void handleCreateTask() {
        try {
            TaskFormView taskFormView = new TaskFormView();
            Task task = taskFormView.render();
            taskService.createTask(task);

            new SuccessView().render(task.getIdTask(), "Tarefa criada com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleUpdateTask() {
        try {
            TaskFormView taskFormView = new TaskFormView();
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            Task oldTask = taskService.findById(idTask);
            Task task = taskFormView.render();
            taskService.updateTaskById(idTask, task);
            task.setIdTask(oldTask.getIdTask());

            new SuccessView().render(task.getIdTask(), "Tarefa atualizada com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleFindAll() {
        try {
            ListAllTasksView listAllTasksView = new ListAllTasksView();
            List<Task> tasks = taskService.findAll();
            listAllTasksView.render(tasks);
        } catch (Exception e) {
            handleErrors(e);
        }

    }

    protected void handleFindTaskById() {
        try {
            TaskDetailsView taskDetailsView = new TaskDetailsView();
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            Task task = taskService.findById(idTask);
            taskDetailsView.render(task);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleRemoveTaskById() {
        try {
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            taskService.removeTaskById(idTask);
            new SuccessView().render(idTask, "Tarefa removida com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleCompleteTaskById() {
        try {
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            taskService.completeTaskById(idTask);
            new SuccessView().render(idTask, "Tarefa completa com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    private void handleErrors(Exception e) {
        if (e instanceof DataAcessException) {
            new DataErrorView().render();
        } else if (e instanceof TaskNotFoundException) {
            new TaskNotFoundView().render();
        } else if (e instanceof TitleTooLongException) {
            new TitleTooLongView().render();
        } else if (e instanceof EmptyDataException) {
            new EmptyDataView().render();
        } else if (e instanceof EmptyListException) {
            new EmptyListView().render();
        } else if (e instanceof TaskAlreadyDoneException) {
            new TaskAlreadyDoneView().render();
        }
    }
}
