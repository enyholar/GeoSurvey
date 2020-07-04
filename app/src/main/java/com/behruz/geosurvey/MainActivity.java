package com.behruz.geosurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.graphics.Color;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.behruz.geosurvey.adapter.SurveyListAdapter;
import com.behruz.geosurvey.api.GeoSurveyClient;
import com.behruz.geosurvey.api.GeoSurveyService;
import com.behruz.geosurvey.databinding.ActivityMainBinding;
import com.behruz.geosurvey.model.SurveyListResponse;
import com.behruz.geosurvey.model.SurveysItem;
import com.behruz.geosurvey.model.UserResponse;
import com.behruz.geosurvey.utils.PreferenUtil;
import com.google.android.material.navigation.NavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    private SurveyListAdapter adapter;
    private PreferenUtil preferenUtil;
    private UserResponse user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        preferenUtil = PreferenUtil.getInstant(getApplicationContext());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,binding.drawerLayout , binding.toolbar, R.string.app_name, R.string.app_name);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        user = preferenUtil.getLoginUser();
        binding.toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24dp);
        binding.toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        binding.toolbar.setTitleTextColor(Color.BLACK);
        binding.navView.setNavigationItemSelectedListener(this);
        setValueToHeader();
        initAdapter();
        fetchSurvey();
    }

    private void setValueToHeader(){
        binding.txtEmail.setText(user.getEmail());
        View hView =  binding.navView.getHeaderView(0);
        TextView nav_user = hView.findViewById(R.id.nav_header_textView);
        nav_user.setText(user.getEmail());
    }

    private void initAdapter(){
        adapter= new SurveyListAdapter(getApplicationContext(), new SurveyListAdapter.ClickListner() {
            @Override
            public void onItemClick(SurveysItem model, int position) {

            }
        });
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        binding.recyclerview.setLayoutManager(mLayoutManager);
        binding.recyclerview.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }


    private void fetchSurvey(){
            GeoSurveyService service = GeoSurveyClient.getRetrofit().create(GeoSurveyService.class);
        service.fetchAllSurvey()
                    .enqueue(new Callback<SurveyListResponse>() {
                        @Override
                        public void onResponse(Call<SurveyListResponse> call, Response<SurveyListResponse> response) {
                            assert response.body() != null;
                            adapter.addAll(response.body().getSurveys());
                        }

                        @Override
                        public void onFailure(Call<SurveyListResponse> call, Throwable t) {

                        }
                    });

    }

//    private void createLayoutDynamically(int n) {
//
//        for (int i = 0; i < n; i++) {
//            Button myButton = new Button(this);
//            myButton.setText("Button :"+i);
//            myButton.setId(i);
//            final int id_ = myButton.getId();
//
//            LinearLayout layout = (LinearLayout) findViewById(R.id.myDynamicLayout);
//            layout.addView(myButton);
//
//            myButton.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View view) {
//                    Toast.makeText(DynamicLayout.this,
//                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
//                            .show();
//                }
//            });
//        }
//
//    }
}