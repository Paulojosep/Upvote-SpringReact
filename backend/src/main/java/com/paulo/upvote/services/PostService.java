package com.paulo.upvote.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paulo.upvote.dto.PostDTO;
import com.paulo.upvote.entities.Post;
import com.paulo.upvote.repositories.PostRepository;
import com.paulo.upvote.services.exceptions.ResourceNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	@Transactional(readOnly = true)
	public List<PostDTO> findAll() {
		List<Post> list = repository.findAll();
		return list.stream().map(x -> new PostDTO(x)).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public PostDTO findById(Long id) {
		Optional<Post> obj = repository.findById(id);
		Post entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new PostDTO(entity);
	}

	@Transactional
	public PostDTO insert(PostDTO dto) {
		Post entity = new Post();
		entity.setTitle(dto.getTitle());
		entity.setText(dto.getText());
		entity = repository.save(entity);
		return new PostDTO(entity);
	}

	@Transactional
	public PostDTO save(Long id, PostDTO dto) {
		try {
			Post entity = repository.getOne(id);
			
			Integer value = entity.getUpvotes();
			entity.setUpvotes(value + 1);
			entity = repository.save(entity);
			return new PostDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found" + id);
		}
	}

}
