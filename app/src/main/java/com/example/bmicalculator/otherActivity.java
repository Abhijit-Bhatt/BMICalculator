package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class otherActivity extends AppCompatActivity {

    double bmiValue;
    TextView advice;

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
        advice = findViewById(R.id.advice);
        advice.setText("Try gaining a little bit of weight!");

        if (bmiValue >= 18.5 && bmiValue <= 24.9){
            image.setImageResource(R.drawable.healthy);
            advice.setText("Keep yourself around this range!");

        }
        else if(bmiValue >= 25 && bmiValue <= 29.9){
            image.setImageResource(R.drawable.overweight);
            advice.setText("Try losing a little bit of weight!");
        }
        else if(bmiValue >=30){
            image.setImageResource(R.drawable.obese);
            advice.setText("Try to lose enough weight to be below 25 bmi!");
        }
    }
}
