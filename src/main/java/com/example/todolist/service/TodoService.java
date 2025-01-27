package com.example.todolist.service;

import com.example.todolist.entity.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    // 모든 할 일 목록 조회
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    // 할 일 저장 (추가 및 수정)
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    // ID로 할 일 조회
    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    // 할 일 삭제
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    // 할 일 완료 상태 토글
    public Todo toggleTodoCompletion(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        todo.setCompleted(!todo.isCompleted()); // 완료 상태 토글
        return todoRepository.save(todo);
    }
}
