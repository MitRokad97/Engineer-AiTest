package com.app.engineerai_exam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Author implements Serializable {

	@SerializedName("value")
	private String value;

	@SerializedName("matchLevel")
	private String matchLevel;

	@SerializedName("matchedWords")
	private List<Object> matchedWords;

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setMatchLevel(String matchLevel){
		this.matchLevel = matchLevel;
	}

	public String getMatchLevel(){
		return matchLevel;
	}

	public void setMatchedWords(List<Object> matchedWords){
		this.matchedWords = matchedWords;
	}

	public List<Object> getMatchedWords(){
		return matchedWords;
	}

	@Override
 	public String toString(){
		return 
			"Author{" + 
			"value = '" + value + '\'' + 
			",matchLevel = '" + matchLevel + '\'' + 
			",matchedWords = '" + matchedWords + '\'' + 
			"}";
		}
}