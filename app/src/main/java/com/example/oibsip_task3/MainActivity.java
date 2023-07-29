package com.example.oibsip_task3;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;
    private String currentNumber = "";
    private double result = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentNumber += button.getText().toString();
        resultTextView.setText(currentNumber);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;
        String op = button.getText().toString();
        if (!currentNumber.isEmpty()) {
            if (!operator.isEmpty()) {
                calculateResult();
            }
            result = Double.parseDouble(currentNumber);
            currentNumber = "";
            operator = op;
        }
    }

    public void onEqualClick(View view) {
        if (!currentNumber.isEmpty() && !operator.isEmpty()) {
            calculateResult();
            operator = "";
        }
    }

    public void onClearClick(View view) {
        currentNumber = "";
        result = 0;
        operator = "";
        resultTextView.setText("");
    }

    public void onToggleSignClick(View view) {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number = -number; // Toggling the sign by multiplying by -1
            currentNumber = String.valueOf(number);
            resultTextView.setText(currentNumber);
        }
    }

    public void onPercentageClick(View view) {
        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            number /= 100; // Converting to percentage
            currentNumber = String.valueOf(number);
            resultTextView.setText(currentNumber);
        }
    }

    private void calculateResult() {
        double num = Double.parseDouble(currentNumber);
        switch (operator) {
            case "+":
                result += num;
                break;
            case "-":
                result -= num;
                break;
            case "*":
                result *= num;
                break;
            case "/":
                if (num != 0) {
                    result /= num;
                } else {
                    result = 0;
                }
                break;
        }
        currentNumber = String.valueOf(result);
        resultTextView.setText(currentNumber);
    }
}