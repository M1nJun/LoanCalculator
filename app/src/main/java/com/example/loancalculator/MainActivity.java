package com.example.loancalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doCalculation(View view){
        TextView msg = findViewById(R.id.message);

        EditText amountField = findViewById(R.id.loanAmount);
        double amount = Double.parseDouble(amountField.getText().toString());

        EditText termField = findViewById(R.id.termYears);
        double termYears = Double.parseDouble(termField.getText().toString());

        EditText APRField = findViewById(R.id.APR);
        double APR = Double.parseDouble(APRField.getText().toString());


        double rate = APR / 1200;
        double n = termYears * 12;

        double payment = (rate * amount) / (1 - Math.pow(1+rate, -n));

        String pmt = String.format("Your monthly payment is $%.2f", payment);
        msg.setText(pmt);
    }
}