package com.crudapplication.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crudapplication.crud.model.MoviedList;
import com.crudapplication.crud.model.NextMoviedList;
import com.crudapplication.crud.service.MoviedService;

@RestController
@CrossOrigin
public class WatchedMovieController {
	
	@Autowired
	public MoviedService moviedService;
	
	@PostMapping("/watched/add")
	public MoviedList addMovied(@RequestBody MoviedList movied) {
		return this.moviedService.addMovied(movied);
	}
	
	@GetMapping("/moviedlist")
	public List<MoviedList> getMovied(){
		return this.moviedService.getMovied();
	}
	
	@GetMapping("/movielist/moviedetail/{id}")
	public MoviedList getMovideDetail(@PathVariable String id){
		return this.moviedService.getMovied(Long.parseLong(id));
	}
	
	@PostMapping("/nextwatched/add")
	public NextMoviedList addNextMovied(@RequestBody NextMoviedList nextmovied) {
		return this.moviedService.addNextMovied(nextmovied);
	}
	
	@PutMapping("/movielist/moviedetail/update/{id}")
	public MoviedList putMoviedDetail(@PathVariable String id,@RequestBody MoviedList movied) {
		movied.setId(Long.parseLong(id));
		return this.moviedService.putMovied(movied);
	}
	
	@PutMapping("/movielist/nextmoviedetail/update/{id}")
	public NextMoviedList putNextMoviedDetail(@PathVariable String id,@RequestBody NextMoviedList nextmovied) {
		nextmovied.setId(Long.parseLong(id));
		return this.moviedService.putNextMovied(nextmovied);
	}
	
	@GetMapping("/nextmoviedlist")
	public List<NextMoviedList> getNextMovied(){
		return this.moviedService.getNextMovied();
	}
	
	@GetMapping("/nextmovielist/moviedetail/{id}")
	public NextMoviedList getNextMovideDetail(@PathVariable String id){
		return this.moviedService.getNextMovied(Long.parseLong(id));
	}
	
	@DeleteMapping("/movielist/moviedetail/deleteItem/{id}")
	public MoviedList deleteMovied(@PathVariable String id) {
		return this.moviedService.deleteMovied(Long.parseLong(id));
	}
	
	@DeleteMapping("/nextmovielist/moviedetail/deleteItem/{id}")
	public NextMoviedList deleteNextMovied(@PathVariable String id) {
		return this.moviedService.deleteNextMovied(Long.parseLong(id));
	}
}
