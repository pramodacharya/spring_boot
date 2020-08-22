package com.hackerrank.github.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.github.repository.ActorRepository;
import com.hackerrank.github.repository.*;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
	@Autowired
	private EventRepository eventRepository;
	private ActorRepository acatoReposiroty;
	private RepoRepository repoReposiroty;
	
	@DeleteMapping(value ="/erase")
	public ResponseEntity<Long> deleteRecords(){	
		eventRepository.deleteAll();
		acatoReposiroty.deleteAll();
		repoReposiroty.deleteAll();		
		 return  new ResponseEntity<>(HttpStatus.OK);
	}
}
