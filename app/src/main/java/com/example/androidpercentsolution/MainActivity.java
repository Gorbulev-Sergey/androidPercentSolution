package com.example.androidpercentsolution;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    NumberPicker water, waterAfterPoint, percentSolution;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        water = findViewById(R.id.water);
        water.setMinValue(0);
        water.setMaxValue(1000);
        water.setValue(1);
        water.setOnValueChangedListener((numberPicker, i, i1) -> {
            setResult();
        });

        waterAfterPoint = findViewById(R.id.waterAfterPoint);
        waterAfterPoint.setMinValue(0);
        waterAfterPoint.setMaxValue(99);
        waterAfterPoint.setOnValueChangedListener((numberPicker, i, i1) -> {
            setResult();
        });

        percentSolution = findViewById(R.id.percentSolution);
        percentSolution.setMinValue(0);
        percentSolution.setMaxValue(100);
        percentSolution.setValue(10);
        percentSolution.setOnValueChangedListener((numberPicker, i, i1) -> {
            setResult();
        });

        result = findViewById(R.id.result);
        setResult();
    }

    void setResult() {
        double res;
        try {
            res = (Double.parseDouble(String.valueOf(water.getValue()) + "." + String.valueOf(waterAfterPoint.getValue())) * 1000 * percentSolution.getValue()) / (100 - percentSolution.getValue());
        } catch (Exception e) {
            res = 0;
        }
        result.setText("Нужно " + String.format("%.2f", res) + " грамм вещества");
    }
}