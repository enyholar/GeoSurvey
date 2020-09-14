package com.behruz.geosurvey.model;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuestionResponse implements Serializable {

	@SerializedName("questions")
	private List<QuestionsItem> questions;

	public List<QuestionsItem> getQuestions(){
		return questions;
	}
}