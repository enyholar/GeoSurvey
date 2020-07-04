package com.behruz.geosurvey.api;

import com.behruz.geosurvey.model.SurveyListResponse;
import com.behruz.geosurvey.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GeoSurveyService {
    @GET("surveys")
    Call<SurveyListResponse> fetchAllSurvey();

    @GET("interviewers/login")
    Call<UserResponse> loginUser(@Query("email") String username, @Query("password") String password);
}
