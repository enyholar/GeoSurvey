package com.behruz.geosurvey;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.behruz.geosurvey.api.GeoSurveyClient;
import com.behruz.geosurvey.api.GeoSurveyService;
import com.behruz.geosurvey.databinding.ActivityLoginBinding;
import com.behruz.geosurvey.model.UserResponse;
import com.behruz.geosurvey.utils.PreferenUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding binding;
    private PreferenUtil preferenUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        preferenUtil = PreferenUtil.getInstant(getApplicationContext());
        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });
    }

    private void openMainActivity() {
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void loginUser(){
        String email = binding.email.getText().toString();
        String password = binding.password.getText().toString();
        if (email.isEmpty()){
            binding.email.setError("Email field cant be empty");
            return;
        }

        if (password.isEmpty()){
            binding.password.setError("Password field cant be empty");
            return;
        }
        GeoSurveyService service = GeoSurveyClient.getRetrofit().create(GeoSurveyService.class);
        service.loginUser(email,password)
                .enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        assert response.body() != null;
                        preferenUtil.saveUserLogin(response.body());
                        openMainActivity();
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {

                    }
                });

    }
}