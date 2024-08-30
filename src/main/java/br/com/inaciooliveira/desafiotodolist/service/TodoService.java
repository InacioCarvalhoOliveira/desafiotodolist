package br.com.inaciooliveira.desafiotodolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.inaciooliveira.desafiotodolist.entity.Todo;
import br.com.inaciooliveira.desafiotodolist.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo save(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo update(Todo todo) {       
        return todoRepository.save(todo);
    }

    public List<Todo> deleteById(Long id) {
        todoRepository.deleteById(id);
        return findAll();
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public List<Todo> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "priority");
        sort = sort.and((Sort.by(Sort.Direction.ASC, "isdone")));
        return todoRepository.findAll(sort);
    }

    public List<Todo> findByDone(boolean isdone) {
        return todoRepository.findByIsdone(isdone);
    }
}
