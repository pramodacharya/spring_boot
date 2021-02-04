package com.hackerrank.github.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;
import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.EventRepository;
import com.hackerrank.github.repository.RepoRepository;

@RestController
public class EventsController {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private ActorRepository actorRepository;
	@Autowired
	private RepoRepository repoRepository;
	@PostMapping( "/events")
	public  ResponseEntity<Long>   addEvent(@RequestBody Event event){		
		if(!eventRepository.existsById(event.getId())) {
			eventRepository.save(event);
			return  new ResponseEntity<>(event.getId(), HttpStatus.CREATED);
		}
		else return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping( "/events/{id}")
	public ResponseEntity<Event>   getEventById(@PathVariable Long id){
		if(!eventRepository.existsById(id)) {
			 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			else return new ResponseEntity<>(eventRepository.getOne(id), HttpStatus.OK);
	}
	
	@GetMapping( "/events")
	public ResponseEntity<List<Event>>   getEvents(){
		List<Event> events = eventRepository.findAll();
		return new ResponseEntity<>(events, HttpStatus.OK);
	}
	@GetMapping("/events/repos/{id}")
	public ResponseEntity<List<Event>>   getEventsByRepoId(@PathVariable Long id){
		if(!repoRepository.existsById(id) ) {
			 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<>(eventRepository.findByRepo(repoRepository.getOne(id)), HttpStatus.OK);
	}
	@GetMapping("/events/actors/{id}")
	public ResponseEntity<List<Event>>   getEventsByActorId(@PathVariable Long id){
		if(!actorRepository.existsById(id) ) {
			 return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		return new ResponseEntity<>(eventRepository.findByActor(actorRepository.getOne(id)), HttpStatus.OK);
	}
}
