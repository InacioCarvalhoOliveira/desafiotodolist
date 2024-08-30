package br.com.inaciooliveira.desafiotodolist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.inaciooliveira.desafiotodolist.entity.Todo;

public interface TodoRepository  extends JpaRepository<Todo, Long> {

    List<Todo> findByDone(boolean done);

} 
