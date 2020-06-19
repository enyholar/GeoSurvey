package com.behruz.geosurvey;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.graphics.Color;
import android.os.Bundle;
import android.text.DynamicLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.behruz.geosurvey.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,binding.drawerLayout , binding.toolbar, R.string.app_name, R.string.app_name);
        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        binding.toolbar.setNavigationIcon(R.drawable.baseline_menu_black_24dp);
        binding.toolbar.setBackgroundColor(Color.parseColor("#ffffff"));
        binding.toolbar.setTitleTextColor(Color.BLACK);
        binding.navView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
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