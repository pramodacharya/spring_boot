package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;

@RestController
@RequestMapping(value = "/events")
public class EventsController {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private ActorRepository acatoReposiroty;
	@Autowired
	private RepoRepository repoReposiroty;
	@PostMapping( "/events")
	public ResponseEntity<Long>  addEvent(@RequestBody Event event){
		if(eventRepository.getOne(event.getId())!=null) {
		eventRepository.save(event);
		 return  new ResponseEntity<>(event.getId(), HttpStatus.CREATED);
		}
		else return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping( "/events/{id}")
	public ResponseEntity<Long>   getEventById(@PathVariable Long id){
		Event event =eventRepository.getOne(id);
		if(event!=null) {
			 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else return new ResponseEntity<>(event.getId(), HttpStatus.OK);
	}
	
	
}
