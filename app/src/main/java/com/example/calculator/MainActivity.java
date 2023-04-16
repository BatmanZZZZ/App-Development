package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText inputField;
    Spinner inputSpinner, outputSpinner;
    TextView outputField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         inputField = findViewById(R.id.editTextTextPersonName);
         inputSpinner = findViewById(R.id.spinner);
         outputSpinner = findViewById(R.id.spinner3);
         outputField = findViewById(R.id.textView6);

        Button convertButton = findViewById(R.id.button4);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convert();
            }
        });
    }

    private void convert() {
        String input = inputField.getText().toString();
        String inputUnit = inputSpinner.getSelectedItem().toString();
        String outputUnit = outputSpinner.getSelectedItem().toString();

        double inputValue = Double.parseDouble(input);
        double outputValue = 0;

        if (inputUnit.equals("cm")) {
            if (outputUnit.equals("inch")) {
                outputValue = inputValue / 2.54;
            } else if (outputUnit.equals("foot")) {
                outputValue = inputValue / 30.48;
            } else {
                outputValue = inputValue;
            }
        } else if (inputUnit.equals("inch")) {
            if (outputUnit.equals("cm")) {
                outputValue = inputValue * 2.54;
            } else if (outputUnit.equals("foot")) {
                outputValue = inputValue / 12;
            } else {
                outputValue = inputValue;
            }
        } else if (inputUnit.equals("foot")) {
            if (outputUnit.equals("cm")) {
                outputValue = inputValue * 30.48;
            } else if (outputUnit.equals("inch")) {
                outputValue = inputValue * 12;
            } else {
                outputValue = inputValue;
            }
        }

        outputField.setText(String.format("%.3f ", outputValue));
    }
}
