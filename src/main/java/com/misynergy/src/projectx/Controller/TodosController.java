package com.misynergy.src.projectx.Controller;

import com.misynergy.src.projectx.Model.Todos;
import com.misynergy.src.projectx.Service.TodosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
public class TodosController {

    @Autowired
    final private TodosService todosService;

    public TodosController(TodosService todosService) {this.todosService = todosService;}

    @GetMapping("todos/{id}")
    public @ResponseBody Todos getTodosInfo(@PathVariable int id){
        return todosService.getTodosInfo(id);
    }

    @GetMapping("todos")
    public @ResponseBody List<Todos> listTodos(){
        return todosService.ListTodos();
    }

    @PostMapping(value = "todos", consumes = "application/json")
    public @ResponseBody Todos saveTodos(@RequestBody Todos todos){
        return todosService.save(todos);
    }

    @PutMapping(value = "todos", consumes = "application/json")
    public @ResponseBody Todos updateTodos(@RequestBody Todos todos){
        return todosService.update(todos);
    }

    @DeleteMapping("todos/{id}")
    public @ResponseBody ResponseEntity<String> deleteTodos(@PathVariable int id){
        try{
            todosService.delete(id);
            return new ResponseEntity<String>("Deleted", HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("failed to delete", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("todos/priority")
    public @ResponseBody List<Todos> findTodosBetweenPriority(@RequestParam("min") int min, @RequestParam("max") int max){
        return todosService.findTodosBetweenPriority(min, max);
    }

    @GetMapping("todos/name/priority")
    public @ResponseBody List<String> findTodosNameByPriority(@RequestParam("priority") int priority){
        return todosService.findTodosNameByPriority(priority);
    }

}
