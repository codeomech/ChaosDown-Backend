package com.programming.techie.springngblog.controller;

import com.programming.techie.springngblog.dto.PostDto;
import com.programming.techie.springngblog.security.PostService;
import com.programming.techie.springngblog.model.ImageModel;
import io.jsonwebtoken.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/posts/")
public class PostController {
	

    @Autowired
    private PostService postService;

    @PostMapping(consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity createPost(@RequestPart("Post") PostDto postDto,
    		                         @RequestPart("imageFile")MultipartFile[] file)
    {
        
        try {
        	Set<ImageModel> images = uploadImage(file);
        	postDto.setPostImages(images);
        	postService.createPost(postDto);
        }
        catch(Exception e){
        	System.out.println(e.getMessage());
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> showAllPosts() {
        return new ResponseEntity<>(postService.showAllPosts(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<PostDto> getSinglePost(@PathVariable @RequestBody Integer id) {
        return new ResponseEntity<>(postService.readSinglePost(id), HttpStatus.OK);
    }
    
    
    public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles)throws java.io.IOException{
    	Set<ImageModel> imageModels = new HashSet<>();
    	
    	for(MultipartFile file: multipartFiles) {
    		ImageModel imageModel = new ImageModel(
    				file.getOriginalFilename(),
    				file.getContentType(),
    				file.getBytes()
    				);
    		imageModels.add(imageModel);
    	}
    	return imageModels;
    } 
    
    @DeleteMapping("/deletePostDetail/{id}")
    public void deletePostDetail(@PathVariable ("id") Integer id) {
		postService.deletePostDetail(id);
    }
    
//    public Post getPostDetailById(Integer productId) {
//    	return PostDao.
//    }
     
}
