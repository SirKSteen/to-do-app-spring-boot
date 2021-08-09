package com.todoapp.rest.webservices.ToDoAppPro.toDo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@CrossOrigin(origins="http://localhost:4300")
public class ToDoJPAResource {

	
	@Autowired
	private ToDoJPARepository todoJPARepository;
	
	/*
	 * Retrieve all ToDos for a User
		GET /users/{username}/todos
		
		Retrieve a Specific ToDo for a User
		GET /users/{username}/todos/{id}
		
		Delete a ToDo of a User
		DELETE /users/{username}/todos/{id}
		
		Edit/Update a ToDo
		PUT /users/{username}/todos/{id}
		
		Create a new ToDo
		POST /users/{username}/todos/
	 * 
	 */
	
	@GetMapping("/users/{username}/todos")
	public List <ToDo> getAllTodos (@PathVariable String username){
		return todoJPARepository.findByUsername(username);		
	}
	
	@GetMapping("/users/{username}/todos/{id}")
	public ToDo getSpecificTodo (@PathVariable String username, 
			@PathVariable long id) {
		return todoJPARepository.findById(id).get();		
	}
	
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<String> deleteTodo(@PathVariable String username, 
			@PathVariable long id){
		todoJPARepository.deleteById(id);
		String response = "ToDo successfully deleted!";
		return ResponseEntity.ok(response);
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public ResponseEntity<ToDo> updateTodo(@PathVariable String username, 
			@PathVariable long id, 
			@RequestBody ToDo todo){
		
		todo.setUsername(username);
		ToDo updatedTodo = todoJPARepository.save(todo);
		return new ResponseEntity<ToDo>(updatedTodo, HttpStatus.OK);
		
	}
	
	@PostMapping("/users/{username}/todos")
	public ResponseEntity<String> createTodo(@PathVariable String username,
			@RequestBody ToDo todo){
		
		todo.setUsername(username);
		
		ToDo createdTodo = todoJPARepository.save(todo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				   .buildAndExpand(createdTodo.getId()).toUri();

		String response = "Successfully created To Do";
		return ResponseEntity.created(uri).build();
//		return ResponseEntity.ok(response);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}















