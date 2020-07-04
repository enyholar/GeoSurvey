package com.behruz.geosurvey.model;

import com.google.gson.annotations.SerializedName;

public class SurveysItem{

	@SerializedName("survey_url")
	private String surveyUrl;

	@SerializedName("description")
	private Object description;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private Object status;

	public String getSurveyUrl(){
		return surveyUrl;
	}

	public Object getDescription(){
		return description;
	}

	public String getTitle(){
		return title;
	}

	public Object getStatus(){
		return status;
	}
}