package com.example.todolist.controller;

import com.example.todolist.entity.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public String getAllTodos(Model model) {
        model.addAttribute("todos", todoService.getAllTodos());
        return "todo-list";
    }

    @PostMapping
    public String addTodo(@RequestParam String title) {
        Todo todo = new Todo();
        todo.setTitle(title);
        todo.setCompleted(false);
        todoService.saveTodo(todo);
        return "redirect:/todos";
    }

    @PostMapping("/toggle/{id}")
    public String toggleTodoCompletion(@PathVariable Long id) {
        todoService.toggleTodoCompletion(id);
        return "redirect:/todos";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todos";
    }
}
