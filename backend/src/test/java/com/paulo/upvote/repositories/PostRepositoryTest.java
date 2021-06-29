package com.paulo.upvote.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.paulo.upvote.entities.Post;

@DataJpaTest
public class PostRepositoryTest {
	
	@Autowired
	private PostRepository repository;
	
	// VARIAVESI INICIALIZAÇÃO
	private long exintingId;
	private long nonExistingId;
	
	@BeforeEach
	void setUp() throws Exception {
		exintingId = 1L;
		nonExistingId = 1000L;
	}
	
	@Test
	public void findByIdShouldExists() {
		Optional<Post> result = repository.findById(exintingId);
		
		Assertions.assertTrue(result.isPresent());
	}
	
	@Test
	public void findByIdShouldNotExists() {
		Optional<Post> result = repository.findById(nonExistingId);
		
		Assertions.assertTrue(result.isEmpty());
	}
	

}
