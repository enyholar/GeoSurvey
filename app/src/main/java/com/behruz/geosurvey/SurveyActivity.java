package com.behruz.geosurvey;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.behruz.geosurvey.api.GeoSurveyClient;
import com.behruz.geosurvey.api.GeoSurveyService;
import com.behruz.geosurvey.model.QuestionResponse;
import com.behruz.geosurvey.model.QuestionsItem;
import com.behruz.geosurvey.model.SurveysItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SurveyActivity extends AppCompatActivity {
    private SurveysItem surveysItem;
    private List<QuestionsItem> surveysItemList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);
        getData();
        if (surveysItem != null){
            fetchSurveyQuestion(surveysItem.getId());
        }
    }

    private void getData() {
        surveysItem = (SurveysItem) getIntent().getSerializableExtra("model");
    }


    private void createLayoutDynamically(int n) {

        for (int i = 0; i < n; i++) {
            Button myButton = new Button(this);
            myButton.setText("Button :"+i);
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = (LinearLayout) findViewById(R.id.container);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(SurveyActivity.this,
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }

    }

    private void fetchSurveyQuestion(String id){
        GeoSurveyService service = GeoSurveyClient.getRetrofit().create(GeoSurveyService.class);
        service.fetchSurveyQuestionById(id)
                .enqueue(new Callback<QuestionResponse>() {
                    @Override
                    public void onResponse(Call<QuestionResponse> call, Response<QuestionResponse> response) {
                        assert response.body() != null;
                        surveysItemList.addAll(response.body().getQuestions());
                    }

                    @Override
                    public void onFailure(Call<QuestionResponse> call, Throwable t) {

                    }
                });

    }
}