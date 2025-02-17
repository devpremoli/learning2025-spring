package org.example.springbootmongoatlas.service;

import org.example.springbootmongoatlas.model.Task;
import org.example.springbootmongoatlas.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task addTask(Task task) {
        task.setTaskId(UUID.randomUUID().toString().split("-")[0]);
        return taskRepository.save(task);
    }

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public Task findTasksByTaskId(String taskId) {
        return taskRepository.findById(taskId).get();
    }

    public List<Task> findTasksBySeverity(int severity) {
        return taskRepository.findBySeverity(severity);
    }

    public List<Task> findTasksByAssignee(String assignee) {
        return taskRepository.getTasksByAssignee(assignee);
    }

    public Task updateTask(Task taskRequest) {
        Task existingTask = taskRepository.findById(taskRequest.getTaskId()).get();
        existingTask.setDescription(taskRequest.getDescription());
        existingTask.setSeverity(taskRequest.getSeverity());
        existingTask.setAssignee(taskRequest.getAssignee());
        existingTask.setStoryPoint(taskRequest.getStoryPoint());
        return taskRepository.save(existingTask);
    }

    public String deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
        return taskId + " deleted";
    }
}
