package com.paulo.upvote.tests;

import com.paulo.upvote.dto.PostDTO;
import com.paulo.upvote.entities.Post;

public class Factory {
	
	public static Post creatPost() {
		Post post = new Post(1L, "Title", "description of title", 10);
		return post;
	}
	
	public static PostDTO createPostDTO() {
		Post post = creatPost();
		return new PostDTO(post);
	}

}
