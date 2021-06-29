package com.paulo.upvote.dto;

import com.paulo.upvote.entities.Post;

public class PostDTO {

	private long id;
	private String title;
	private String text;
	private Integer upvotes;

	public PostDTO() {
	}

	public PostDTO(long id, String title, String text, Integer upvotes) {
		this.id = id;
		this.title = title;
		this.text = text;
		this.upvotes = upvotes;
	}

	public PostDTO(Post entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.text = entity.getText();
		this.upvotes = entity.getUpvotes();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Integer getUpvotes() {
		return upvotes;
	}

	public void setUpvotes(Integer upvotes) {
		this.upvotes = upvotes;
	}

}
