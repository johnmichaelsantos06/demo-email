package com.demo.models;

public class FeedbackInfo {
	
	private Integer rating;
	private String email;

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "FeedbackInfo [rating=" + rating + ", email=" + email + "]";
	}
}
