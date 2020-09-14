package com.behruz.geosurvey.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SurveysItem implements Serializable {

	@SerializedName("survey_url")
	private String surveyUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("description")
	private String description;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private String status;

	public String getSurveyUrl(){
		return surveyUrl;
	}

	public String getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public String getStatus(){
		return status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}