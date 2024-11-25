package org.example.spring24.todo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TodoController {

    TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/api/todo")
    public List<Todo> getTodos(){
        long start = System.currentTimeMillis();
        var todos = service.getTodos();
        long end = System.currentTimeMillis();
        log.info("Retrieving all from todos api in {} ms.", end - start);

        return todos;
    }

    @GetMapping("/api/todo/{id}")
    public Todo getTodos(@PathVariable("id") long id){
        long start = System.currentTimeMillis();
        var todo = service.getOne(id);
        long end = System.currentTimeMillis();
        log.info("Retrieving id: {} from todos api in {} ms.", id, end - start);
        return todo;
    }

}
