package com.example.evalution_1;

import java.util.List;
import java.io.Serializable;

public class NowShowingModel implements Serializable {
	private String id;
	private String title;
	private String year;
	private String contentRating;
	private String duration;
	private String releaseDate;
	private int averageRating;
	private String originalTitle;
	private String storyline;
	private List<String> actors;
	private Object imdbRating;
	private String posterurl;
	private String videoUrl;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setYear(String year){
		this.year = year;
	}

	public String getYear(){
		return year;
	}

	public void setContentRating(String contentRating){
		this.contentRating = contentRating;
	}

	public String getContentRating(){
		return contentRating;
	}

	public void setDuration(String duration){
		this.duration = duration;
	}

	public String getDuration(){
		return duration;
	}

	public void setReleaseDate(String releaseDate){
		this.releaseDate = releaseDate;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public void setAverageRating(int averageRating){
		this.averageRating = averageRating;
	}

	public int getAverageRating(){
		return averageRating;
	}

	public void setOriginalTitle(String originalTitle){
		this.originalTitle = originalTitle;
	}

	public String getOriginalTitle(){
		return originalTitle;
	}

	public void setStoryline(String storyline){
		this.storyline = storyline;
	}

	public String getStoryline(){
		return storyline;
	}

	public void setActors(List<String> actors){
		this.actors = actors;
	}

	public List<String> getActors(){
		return actors;
	}

	public void setImdbRating(Object imdbRating){
		this.imdbRating = imdbRating;
	}

	public Object getImdbRating(){
		return imdbRating;
	}

	public void setPosterurl(String posterurl){
		this.posterurl = posterurl;
	}

	public String getPosterurl(){
		return posterurl;
	}

	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}

	public String getVideoUrl(){
		return videoUrl;
	}

	@Override
 	public String toString(){
		return 
			"NowShowingModel{" + 
			"id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			",year = '" + year + '\'' + 
			",contentRating = '" + contentRating + '\'' + 
			",duration = '" + duration + '\'' + 
			",releaseDate = '" + releaseDate + '\'' + 
			",averageRating = '" + averageRating + '\'' + 
			",originalTitle = '" + originalTitle + '\'' + 
			",storyline = '" + storyline + '\'' + 
			",actors = '" + actors + '\'' + 
			",imdbRating = '" + imdbRating + '\'' + 
			",posterurl = '" + posterurl + '\'' + 
			",video_url = '" + videoUrl + '\'' + 
			"}";
		}
}