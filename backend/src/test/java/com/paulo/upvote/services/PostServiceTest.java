package com.paulo.upvote.services;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.paulo.upvote.dto.PostDTO;
import com.paulo.upvote.entities.Post;
import com.paulo.upvote.repositories.PostRepository;
import com.paulo.upvote.tests.Factory;

@ExtendWith(SpringExtension.class)
public class PostServiceTest {
	
	@Mock
	private PostRepository repository;
	
	@InjectMocks
	private PostService service;
	
	@Mock
	private Post post;
	
	private long existingId;
	private long nonExistingId;
	
	@BeforeEach
	public void setUp() throws Exception {
		post = Factory.creatPost();
		
		existingId = 1L;
		nonExistingId = 1000L;
		
		Mockito.when(repository.findById(existingId)).thenReturn(Optional.of(post));
		Mockito.when(repository.findById(nonExistingId)).thenReturn(Optional.empty());
	}
	
	@Test
	public void findByIdShouldReturnPostDTOIfIdExist() {
		PostDTO result = service.findById(existingId);
		
		Assertions.assertNotNull(result);
	}

}
