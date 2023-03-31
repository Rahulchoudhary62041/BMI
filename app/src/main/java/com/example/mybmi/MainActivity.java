package com.example.mybmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, ediHeightIn;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        ediHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        llMain = findViewById(R.id.llMain);


        btnCalculate.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                int wt = Integer.parseInt(edtWeight.getText().toString());
                int ft = Integer.parseInt(edtHeightFt.getText().toString());
                int in = Integer.parseInt(ediHeightIn.getText().toString());


                int totalIn = ft*12 +in;

                double totalCm = totalIn*2.53;

                double totalM = totalCm/100;

                double bmi = wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("You'r Overweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorO));

                } else if (bmi<18){
                    txtResult.setText("You'r  Underweight");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                } else {
                    txtResult.setText("You'r  Healthy");
                    llMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });



    }
}