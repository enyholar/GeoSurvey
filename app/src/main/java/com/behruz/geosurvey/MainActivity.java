package com.behruz.geosurvey;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void createLayoutDynamically(int n) {

        for (int i = 0; i < n; i++) {
            Button myButton = new Button(this);
            myButton.setText("Button :"+i);
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = (LinearLayout) findViewById(R.id.myDynamicLayout);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Toast.makeText(DynamicLayout.this,
                            "Button clicked index = " + id_, Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
}