package com.programming.techie.springngblog.dto;

import java.util.Set;

import com.programming.techie.springngblog.model.ImageModel;

public class PostDto {
    private Integer id;
    private String content;
    private String title;
    private String username;
    private Set<ImageModel> postImages;
    private Integer popularity;
    

    
    public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

    
    public Set<ImageModel> getPostImages() {
		return postImages;
	}

	public void setPostImages(Set<ImageModel> postImages) {
		this.postImages = postImages;
	}
	



    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
