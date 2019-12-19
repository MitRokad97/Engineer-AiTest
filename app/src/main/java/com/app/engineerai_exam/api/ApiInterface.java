package com.app.engineerai_exam.api;

import com.app.engineerai_exam.model.Story;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("search_by_date?tags=story")
    Call<Story> getStory(@Query("page") int page);
}
