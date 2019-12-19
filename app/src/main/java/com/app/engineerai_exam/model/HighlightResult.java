package com.app.engineerai_exam.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HighlightResult implements Serializable {

	@SerializedName("title")
	private Title title;

	@SerializedName("url")
	private Url url;

	@SerializedName("author")
	private Author author;

	public void setTitle(Title title){
		this.title = title;
	}

	public Title getTitle(){
		return title;
	}

	public void setUrl(Url url){
		this.url = url;
	}

	public Url getUrl(){
		return url;
	}

	public void setAuthor(Author author){
		this.author = author;
	}

	public Author getAuthor(){
		return author;
	}

	@Override
 	public String toString(){
		return 
			"HighlightResult{" + 
			"title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",author = '" + author + '\'' + 
			"}";
		}
}