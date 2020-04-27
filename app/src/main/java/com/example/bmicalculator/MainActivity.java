package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    EditText weightText;
    EditText heightText;
    RadioGroup radioGroup;
    RadioButton imperial;
    RadioButton metric;
    TextView BMI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onStart(){
        super.onStart();
        weightText = findViewById(R.id.editText);
        heightText = findViewById(R.id.editText2);
        radioGroup = findViewById(R.id.radioGroup);
        imperial = findViewById(R.id.imperial);
        metric = findViewById(R.id.metric);
        BMI = findViewById(R.id.output);
    }

    public void onLeftButtonPress(View view){
        weightText.setHint("Enter weight in pounds");
        heightText.setHint("Enter height in inches");
    }

    public void onRightButtonPress(View view){
        weightText.setHint("Enter weight in kilograms");
        heightText.setHint("Enter height in meters");
    }

    public void clickGetAdvice(View view){
        Intent newAdvice = new Intent(MainActivity.this, otherActivity.class);
        startActivity(newAdvice);
    }


    public void checkBMI(View view){
        double weight;
        double height;
        try{
            weight = Double.parseDouble(weightText.getText().toString());
            height = Double.parseDouble(heightText.getText().toString());
        }
        catch(Exception e){
            Toast.makeText(getApplicationContext(), "Enter values", Toast.LENGTH_SHORT).show();
            return;
        }

        if(imperial.isChecked()){
            double bmi = (weight*703)/(height*height);
            bmi = Math.round(bmi * 100.0) /100.0;
            BMI.setText(String.valueOf(bmi));
        }

        else if(metric.isChecked()){
            double bmi = (weight)/(height*height);
            bmi = Math.round(bmi * 100.0) /100.0;
            BMI.setText(String.valueOf(bmi));
        }

        else {
            Toast.makeText(getApplicationContext(), "Select unit type", Toast.LENGTH_SHORT).show();
        }

    }
}

