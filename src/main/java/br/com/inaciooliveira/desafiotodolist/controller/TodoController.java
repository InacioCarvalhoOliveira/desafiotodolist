package br.com.inaciooliveira.desafiotodolist.controller;

import br.com.inaciooliveira.desafiotodolist.entity.Todo;
import br.com.inaciooliveira.desafiotodolist.service.TodoService;
import jakarta.validation.Valid;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;
    
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public ResponseEntity<Todo> save(@RequestBody @Valid Todo todo) {
        Todo savedTodo = todoService.save(todo);
        return new ResponseEntity<Todo>(savedTodo, HttpStatus.CREATED);

    }

    @PutMapping
    public Todo update(@RequestBody Todo todo) {
        return todoService.update(todo);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        todoService.deleteById(id);
        return "Todo with id " + id + " deleted successfully.";
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable("id") Long id) {
        return todoService.findById(id);
    }

    @GetMapping
    public List<Todo> findAll() {
        return todoService.findAll();
    }

    @GetMapping("/done/{isdone}")
    public List<Todo> findByDone(@PathVariable("isdone") boolean isdone) {
        return todoService.findByDone(isdone);
    }
}