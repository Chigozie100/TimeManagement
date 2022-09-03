package com.example.demo.Controller;

import com.example.demo.Entity.Task;
import com.example.demo.Service.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TaskController {
    @Autowired
    ITaskService iTaskService;
    @GetMapping("/viewAddTask")
    public String viewPage(Model model){
        model.addAttribute("task",new Task());
        return "addTask";
    }
    @PostMapping("/taskPage")
    public String saveTask(Model model, @ModelAttribute("task1") Task task) {
        Task tasks = iTaskService.addTask(task);
        model.addAttribute("task", tasks);
        return "redirect:/";
    }
    @GetMapping("/viewAllTasks")
    public String viewAllTasks(Model model){
        List<Task> taskList =iTaskService.getAllTasks();
        model.addAttribute("taskList", taskList);
        return "viewAllTasks";
    }

    @GetMapping("/editTask/{id}")
    public String showEdit(@PathVariable("id") int id, Model model){
       Task task = iTaskService.getTaskById(id);
       model.addAttribute("task", task);
       return "editTask";
    }

    @PostMapping("/editTasks/{id}")
    public String editTask(@PathVariable("id") int id, Model model, @ModelAttribute("task1") Task task){
        model.addAttribute("task", new Task());
        iTaskService.updateTask(id,task);
        return "redirect:/viewAllTasks";
    }

    @GetMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable("id") int id){
        iTaskService.deleteTask(id);
        return "redirect:/viewAllTasks";
    }

    @GetMapping("/doneTask/{id}")
    public String doneTask(@PathVariable("id") int id, Model model, @ModelAttribute("task1") Task task){
        model.addAttribute("task", new Task());
        iTaskService.doneTask(id,task);
        return "redirect:/viewAllTasks";
    }

    @GetMapping("/pendingTask")
    public String pendingTask(Model model){
        model.addAttribute("task",iTaskService.getTaskByStatusPending() );
        return "pendingTask";
    }

    @GetMapping("/doneTask")
    public String doneTask(Model model){
        model.addAttribute("task", iTaskService.getTaskByStatusDone());
        return "doneTask";
    }

    @GetMapping("/inProgressTask")
    public String inProgressTask(Model model){
        model.addAttribute("task", iTaskService.getTaskByStatusInProgress());
        return "inProgressTask";
    }
}
