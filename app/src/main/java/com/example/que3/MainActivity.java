package com.example.que3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private EditText editTextRadius;
    private TextView textViewResult;
    private ToggleButton toggleButtonCalculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextRadius = findViewById(R.id.editTextRadius);
        textViewResult = findViewById(R.id.textViewResult);
        toggleButtonCalculation = findViewById(R.id.toggleButtonCalculation);

        toggleButtonCalculation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateCircumferenceOrArea();
            }
        });
    }

    private void calculateCircumferenceOrArea() {
        String radiusText = editTextRadius.getText().toString();
        if (radiusText.isEmpty()) {
            textViewResult.setText("Please enter a radius.");
            return;
        }

        double radius = Double.parseDouble(radiusText);
        boolean isCircumferenceSelected = toggleButtonCalculation.isChecked();
        double result = isCircumferenceSelected ? calculateCircumference(radius) : calculateArea(radius);

        String resultText = isCircumferenceSelected ? "Circumference: " : "Area: ";
        resultText += result;
        textViewResult.setText(resultText);
    }

    private double calculateCircumference(double radius) {
        return 2 * Math.PI * radius;
    }

    private double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }
}
