package com.behruz.geosurvey.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SurveyListResponse{

	@SerializedName("surveys")
	private List<SurveysItem> surveys;

	public List<SurveysItem> getSurveys(){
		return surveys;
	}
}