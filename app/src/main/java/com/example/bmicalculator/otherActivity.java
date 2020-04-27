package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class otherActivity extends AppCompatActivity {

    double bmiValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        setTitle("Advice based on BMI");
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        bmiValue = bundle.getDouble("bmi value");
        ImageView image = findViewById(R.id.imageView);
        if (bmiValue >= 18.5 && bmiValue <= 24.9){
            image.setImageResource(R.drawable.healthy);
        }
        else if(bmiValue >= 25 && bmiValue <= 29.9){
            image.setImageResource(R.drawable.overweight);
        }
        else if(bmiValue >=30){
            image.setImageResource(R.drawable.obese);
        }
    }
}
