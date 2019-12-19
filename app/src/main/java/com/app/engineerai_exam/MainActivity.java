package com.app.engineerai_exam;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.app.engineerai_exam.api.ServiceGenerator;
import com.app.engineerai_exam.model.Story;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        storyApiCall();
    }

    private void storyApiCall() {
        Call<Story> storyList = ServiceGenerator.createService().getStory(1);
        storyList.enqueue(new Callback<Story>() {
            @Override
            public void onResponse(Call<Story> call, Response<Story> response) {
                Story story = response.body();
            }

            @Override
            public void onFailure(Call<Story> call, Throwable t) {

            }
        });
    }
}
