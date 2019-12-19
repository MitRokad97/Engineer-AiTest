package com.app.engineerai_exam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class HitsItem implements Serializable {

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("title")
	private String title;

	@SerializedName("url")
	private String url;

	@SerializedName("author")
	private String author;

	@SerializedName("points")
	private int points;

	@SerializedName("story_text")
	private Object storyText;

	@SerializedName("comment_text")
	private Object commentText;

	@SerializedName("num_comments")
	private int numComments;

	@SerializedName("story_id")
	private Object storyId;

	@SerializedName("story_title")
	private Object storyTitle;

	@SerializedName("story_url")
	private Object storyUrl;

	@SerializedName("parent_id")
	private Object parentId;

	@SerializedName("created_at_i")
	private int createdAtI;

	@SerializedName("_tags")
	private List<String> tags;

	@SerializedName("objectID")
	private String objectID;

	@SerializedName("_highlightResult")
	private HighlightResult highlightResult;

	private Boolean isChecked = false;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setAuthor(String author){
		this.author = author;
	}

	public String getAuthor(){
		return author;
	}

	public void setPoints(int points){
		this.points = points;
	}

	public int getPoints(){
		return points;
	}

	public void setStoryText(Object storyText){
		this.storyText = storyText;
	}

	public Object getStoryText(){
		return storyText;
	}

	public void setCommentText(Object commentText){
		this.commentText = commentText;
	}

	public Object getCommentText(){
		return commentText;
	}

	public void setNumComments(int numComments){
		this.numComments = numComments;
	}

	public int getNumComments(){
		return numComments;
	}

	public void setStoryId(Object storyId){
		this.storyId = storyId;
	}

	public Object getStoryId(){
		return storyId;
	}

	public void setStoryTitle(Object storyTitle){
		this.storyTitle = storyTitle;
	}

	public Object getStoryTitle(){
		return storyTitle;
	}

	public void setStoryUrl(Object storyUrl){
		this.storyUrl = storyUrl;
	}

	public Object getStoryUrl(){
		return storyUrl;
	}

	public void setParentId(Object parentId){
		this.parentId = parentId;
	}

	public Object getParentId(){
		return parentId;
	}

	public void setCreatedAtI(int createdAtI){
		this.createdAtI = createdAtI;
	}

	public int getCreatedAtI(){
		return createdAtI;
	}

	public void setTags(List<String> tags){
		this.tags = tags;
	}

	public List<String> getTags(){
		return tags;
	}

	public void setObjectID(String objectID){
		this.objectID = objectID;
	}

	public String getObjectID(){
		return objectID;
	}

	public void setHighlightResult(HighlightResult highlightResult){
		this.highlightResult = highlightResult;
	}

	public HighlightResult getHighlightResult(){
		return highlightResult;
	}

	@Override
 	public String toString(){
		return 
			"HitsItem{" + 
			"created_at = '" + createdAt + '\'' + 
			",title = '" + title + '\'' + 
			",url = '" + url + '\'' + 
			",author = '" + author + '\'' + 
			",points = '" + points + '\'' + 
			",story_text = '" + storyText + '\'' + 
			",comment_text = '" + commentText + '\'' + 
			",num_comments = '" + numComments + '\'' + 
			",story_id = '" + storyId + '\'' + 
			",story_title = '" + storyTitle + '\'' + 
			",story_url = '" + storyUrl + '\'' + 
			",parent_id = '" + parentId + '\'' + 
			",created_at_i = '" + createdAtI + '\'' + 
			",_tags = '" + tags + '\'' + 
			",objectID = '" + objectID + '\'' + 
			",_highlightResult = '" + highlightResult + '\'' + 
			"}";
		}

	public Boolean getChecked() {
		return isChecked;
	}

	public void setChecked(Boolean checked) {
		isChecked = checked;
	}
}