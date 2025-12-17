package app.controller;

import app.exceptions.*;
import app.model.Task;
import app.ports.ITaskDetailsView;
import app.ports.ITaskListView;
import app.ports.IOutputMessage;
import app.service.TaskService;
import app.view.IdInputView;
import app.view.TaskFormView;

import java.util.List;

public class TaskCommandHandler {

    private final TaskService taskService;
    private final IOutputMessage outputMessage;
    private final ITaskListView taskListView;
    private final ITaskDetailsView taskDetailsView;

    public TaskCommandHandler(TaskService taskService, IOutputMessage outputMessage, ITaskListView taskListView, ITaskDetailsView taskDetailsView) {
        this.taskService = taskService;
        this.outputMessage = outputMessage;
        this.taskListView = taskListView;
        this.taskDetailsView = taskDetailsView;
    }

    protected void handleCreateTask() {
        try {
            TaskFormView taskFormView = new TaskFormView();
            Task task = taskFormView.render();
            taskService.createTask(task);

            outputMessage.displaySuccess("Tarefa criada com sucesso!");
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

            outputMessage.displaySuccess("Tarefa atualizada com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleFindAll() {
        try {
            List<Task> tasks = taskService.findAll();
            taskListView.display(tasks);
        } catch (Exception e) {
            handleErrors(e);
        }

    }

    protected void handleFindTaskById() {
        try {
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            Task task = taskService.findById(idTask);
            taskDetailsView.display(task);
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleRemoveTaskById() {
        try {
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            taskService.removeTaskById(idTask);
            outputMessage.displaySuccess("Tarefa removida com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    protected void handleCompleteTaskById() {
        try {
            IdInputView idInputView = new IdInputView();
            int idTask = idInputView.getTaskId();
            taskService.completeTaskById(idTask);
            outputMessage.displaySuccess("Tarefa marcada como concluída com sucesso!");
        } catch (Exception e) {
            handleErrors(e);
        }
    }

    private void handleErrors(Exception e) {
        if (e instanceof DataAcessException) {
            outputMessage.displayError("Houve um erro ao se conectar com o banco de dados. Por favor, aguarde até que seja reestabelecido.");
        } else if (e instanceof TaskNotFoundException) {
            outputMessage.displayError("Tarefa não encontrada!");
        } else if (e instanceof TitleTooLongException) {
            outputMessage.displayError("Seu título é muito longo. Por favor, use menos de 30 caracteres.");
        } else if (e instanceof EmptyDataException) {
            outputMessage.displayError("Todos os campos tem que ser preenchidos!");
        } else if (e instanceof EmptyListException) {
            outputMessage.displayError("Nenhuma tarefa encontrada!");
        } else if (e instanceof TaskAlreadyDoneException) {
            outputMessage.displayWarning("Tarefa já foi concluída");
        }
    }
}
