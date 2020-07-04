package com.behruz.geosurvey.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserResponse implements Serializable {

	@SerializedName("firstName")
	private String firstName;

	@SerializedName("lastName")
	private String lastName;

	@SerializedName("password")
	private String password;

	@SerializedName("interviewer_url")
	private Object interviewerUrl;

	@SerializedName("phone")
	private Object phone;

	@SerializedName("email")
	private String email;

	public String getFirstName(){
		return firstName;
	}

	public String getLastName(){
		return lastName;
	}

	public String getPassword(){
		return password;
	}

	public Object getInterviewerUrl(){
		return interviewerUrl;
	}

	public Object getPhone(){
		return phone;
	}

	public String getEmail(){
		return email;
	}
}