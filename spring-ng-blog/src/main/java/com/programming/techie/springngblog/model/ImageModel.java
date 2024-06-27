package com.programming.techie.springngblog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="image_model")
public class ImageModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;
	private String name;
	private String type;
	@Column(length = 500000)
	private byte[] picByte;
	
	public ImageModel() {
		
	}

//	public ImageModel(String name, String type, byte[] picByte) {
//		super();
//		this.name = name;
//		this.type = type;
//		this.picByte = picByte;
//	}

	public ImageModel(String originalFilename, String contentType, byte[] bytes) {
		this.name = originalFilename;
		this.type = contentType;
		this.picByte = bytes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicByte() {
		return picByte;
	}

	public void setPicByte(byte[] picByte) {
		this.picByte = picByte;
	}
	
	

}
