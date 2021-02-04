package com.hackerrank.github.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackerrank.github.model.Actor;
import com.hackerrank.github.model.Event;
import com.hackerrank.github.model.Repo;

public interface EventRepository extends JpaRepository <Event,Long>{

	List<Event> findByRepo(Repo repo);

	List<Event> findByActor(Actor actor);

}