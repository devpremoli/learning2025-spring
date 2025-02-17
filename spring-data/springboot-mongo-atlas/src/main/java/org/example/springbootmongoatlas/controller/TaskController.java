package org.example.springbootmongoatlas.controller;

import org.example.springbootmongoatlas.model.Task;
import org.example.springbootmongoatlas.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.findAllTasks();
    }

    @PutMapping
    public Task updateTask(@RequestBody Task task) {
        return taskService.updateTask(task);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable String id) {
        return taskService.findTasksByTaskId(id);
    }

    @GetMapping("/severity/{severity}")
    public List<Task> getTaskBySeverity(@PathVariable int severity) {
        return taskService.findTasksBySeverity(severity);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTaskByAssignee(@PathVariable String assignee) {
        return taskService.findTasksByAssignee(assignee);
    }

    @DeleteMapping("/{id}")
    public String deleteTaskById(@PathVariable String id) {
        return taskService.deleteTask(id);
    }
}
