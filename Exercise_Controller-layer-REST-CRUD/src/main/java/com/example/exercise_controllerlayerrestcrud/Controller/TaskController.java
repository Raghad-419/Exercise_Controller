package com.example.exercise_controllerlayerrestcrud.Controller;

import com.example.exercise_controllerlayerrestcrud.ApiResponse.ApiResponse;
import com.example.exercise_controllerlayerrestcrud.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> getTasks() {
        return tasks;
    }


    @PostMapping("/add")
    public ApiResponse addTask(@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse("Task added successfully");
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index,@RequestBody Task task) {
        if(!tasks.isEmpty()){
        tasks.set(index, task);
        return new ApiResponse("Task updated successfully");}
        else return new ApiResponse("Task not found");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index) {
        if(!tasks.isEmpty()){
        tasks.remove(index);
        return new ApiResponse("Task deleted successfully");}
        else return new ApiResponse("No task found");
    }

    @PutMapping("/update/status/{index}")
        public ApiResponse changeStatus(@PathVariable int index) {
        tasks.get(index).setStatus("Done");
        return new ApiResponse("Task status updated successfully");
}

@GetMapping("/search/{title}")
public Task searchTaskByTitle(@PathVariable String title) {
        for (Task task : tasks) {
            if(task.getTitle().equalsIgnoreCase(title))
                return task;
        }
        return null;
}


}
