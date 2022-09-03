package com.example.demo.Service;

import com.example.demo.DateTime.CurrentDateTime;
import com.example.demo.Entity.Status;
import com.example.demo.Entity.Task;
import com.example.demo.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;

@Service
public class TaskService implements ITaskService{
    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task addTask(Task task) {
        task.setStatus(Status.PENDING.name());
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(int id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void updateTask(int id, Task task) {
        Task task1 =taskRepository.findById(id).orElse(null);
        if (task1 != null){
            task1.setTitle(task.getTitle());
            task1.setDescription(task.getDescription());
            task1.setStatus(Status.IN_PROGRESS.name());
            task1.setUpdatedDate(CurrentDateTime.getDate());
            task1.setUpdatedTime(CurrentDateTime.getTime());
            task1.setCompletedDate(null);
            task1.setCompletedTime(null);
            taskRepository.save(task1);
        }
    }
    @Override
    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void doneTask(int id, Task task) {
        Task task1 = taskRepository.findById(id).orElse(null);
        if (task1 != null){
            task1.setStatus(Status.DONE.name());
            task1.setCompletedDate(CurrentDateTime.getDate());
            task1.setCompletedTime(CurrentDateTime.getTime());
            taskRepository.save(task1);
        }
    }

    @Override
    public List<Task> getTaskByStatusPending() {
        Optional<List<Task>> task = taskRepository.findTasksByStatus(Status.PENDING.name());
        return task.get();
    }

    @Override
    public List<Task> getTaskByStatusDone() {
        Optional<List<Task>> task = taskRepository.findTasksByStatus(Status.DONE.name());
        return task.get();
    }

    @Override
    public List<Task> getTaskByStatusInProgress() {
        Optional<List<Task>> task = taskRepository.findTasksByStatus(Status.IN_PROGRESS.name());
        return task.get();
    }


}
