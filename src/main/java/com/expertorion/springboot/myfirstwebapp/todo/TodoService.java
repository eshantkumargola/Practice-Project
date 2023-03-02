package com.expertorion.springboot.myfirstwebapp.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	
	private static List<Todo> todos=new ArrayList<Todo>();
	private static int countTodos=0;
	
	static {
		todos.add(new Todo(++countTodos,"expertorion","Learn AWS"   ,LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodos,"expertorion","Learn GCP"   ,LocalDate.now().plusYears(1),false));
		todos.add(new Todo(++countTodos,"expertorion","Learn Docker",LocalDate.now().plusYears(2),false));
		todos.add(new Todo(++countTodos,"expertorion","Learn Kn8s"  ,LocalDate.now().plusYears(1),false));
	}

	public List<Todo> findByUsername(String username){
		return todos;
	}	
	
	public void addTodo(String username, String description, LocalDate targetDate, boolean isDone) {		
		//todos=findByUsername(username);
		Todo todo=new Todo(++countTodos,username, description, targetDate, isDone);
		todos.add(todo);
	}	
	
	public void deleteById(int id) {		
		Predicate<? super Todo> predicate = todo -> todo.getId()== id ;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId()== id ;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo ;
	}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		++countTodos;
		todos.add(todo);		
	}	
}
