package com.app.engineerai_exam.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Story implements Serializable {

	@SerializedName("hits")
	private List<HitsItem> hits;

	@SerializedName("nbHits")
	private int nbHits;

	@SerializedName("page")
	private int page;

	@SerializedName("nbPages")
	private int nbPages;

	@SerializedName("hitsPerPage")
	private int hitsPerPage;

	@SerializedName("exhaustiveNbHits")
	private boolean exhaustiveNbHits;

	@SerializedName("query")
	private String query;

	@SerializedName("params")
	private String params;

	@SerializedName("processingTimeMS")
	private int processingTimeMS;

	public void setHits(List<HitsItem> hits){
		this.hits = hits;
	}

	public List<HitsItem> getHits(){
		return hits;
	}

	public void setNbHits(int nbHits){
		this.nbHits = nbHits;
	}

	public int getNbHits(){
		return nbHits;
	}

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setNbPages(int nbPages){
		this.nbPages = nbPages;
	}

	public int getNbPages(){
		return nbPages;
	}

	public void setHitsPerPage(int hitsPerPage){
		this.hitsPerPage = hitsPerPage;
	}

	public int getHitsPerPage(){
		return hitsPerPage;
	}

	public void setExhaustiveNbHits(boolean exhaustiveNbHits){
		this.exhaustiveNbHits = exhaustiveNbHits;
	}

	public boolean isExhaustiveNbHits(){
		return exhaustiveNbHits;
	}

	public void setQuery(String query){
		this.query = query;
	}

	public String getQuery(){
		return query;
	}

	public void setParams(String params){
		this.params = params;
	}

	public String getParams(){
		return params;
	}

	public void setProcessingTimeMS(int processingTimeMS){
		this.processingTimeMS = processingTimeMS;
	}

	public int getProcessingTimeMS(){
		return processingTimeMS;
	}

	@Override
 	public String toString(){
		return 
			"Story{" +
			"hits = '" + hits + '\'' + 
			",nbHits = '" + nbHits + '\'' + 
			",page = '" + page + '\'' + 
			",nbPages = '" + nbPages + '\'' + 
			",hitsPerPage = '" + hitsPerPage + '\'' + 
			",exhaustiveNbHits = '" + exhaustiveNbHits + '\'' + 
			",query = '" + query + '\'' + 
			",params = '" + params + '\'' + 
			",processingTimeMS = '" + processingTimeMS + '\'' + 
			"}";
		}
}