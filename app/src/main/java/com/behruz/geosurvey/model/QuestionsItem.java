package com.behruz.geosurvey.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class QuestionsItem implements Serializable {

	@SerializedName("question_url")
	private String questionUrl;

	@SerializedName("id")
	private String id;

	@SerializedName("questionType")
	private String questionType;

	@SerializedName("questionText")
	private String questionText;

	public String getQuestionUrl(){
		return questionUrl;
	}

	public String getId(){
		return id;
	}

	public String getQuestionType(){
		return questionType;
	}

	public String getQuestionText(){
		return questionText;
	}
}