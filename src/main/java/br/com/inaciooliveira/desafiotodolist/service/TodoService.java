package br.com.inaciooliveira.desafiotodolist.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inaciooliveira.desafiotodolist.entity.Todo;
import br.com.inaciooliveira.desafiotodolist.repository.TodoRepository;

@Service
public class TodoService {

    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {       
        return todoRepository.save(todo);
    }

    public String deleteById(Long id) {
        todoRepository.deleteById(id);
        return ("Task Successfully Deleted");
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Todo> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "priority");
        sort = sort.and(Sort.by(Sort.Direction.ASC, "name"));
        return todoRepository.findAll(sort);
    }

    public List<Todo> findByDone(boolean done) {
        return todoRepository.findByDone(done);
    }
}
