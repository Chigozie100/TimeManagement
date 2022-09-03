package com.example.demo.Service;

import com.example.demo.Entity.Task;

import java.util.List;

public interface ITaskService {
    Task addTask(Task task);

    List<Task> getAllTasks();

    Task getTaskById(int id);

    void updateTask(int id, Task task);

    void deleteTask(int id);

    void doneTask(int id, Task task);

    List<Task> getTaskByStatusPending();

    List<Task> getTaskByStatusDone();

    List<Task> getTaskByStatusInProgress();

}
