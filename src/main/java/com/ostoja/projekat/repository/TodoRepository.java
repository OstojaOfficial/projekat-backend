package com.ostoja.projekat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ostoja.projekat.model.Todo;

import java.time.LocalDateTime;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {

	List<Todo> findByTitle(String title);

	@Query("SELECT b FROM Todo b WHERE b.createdAt > :date")
	List<Todo> findByPublishedDateAfter(@Param("date") LocalDateTime date);

}