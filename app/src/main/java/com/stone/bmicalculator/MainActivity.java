package com.stone.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 EditText editWgt,editHgt;
 TextView textInter,textRes;
 Button RsltBtn,RstBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editWgt=findViewById(R.id.editWgt);
        editHgt=findViewById(R.id.editHgt);

        textInter=findViewById(R.id.textInter);
        textRes=findViewById(R.id.textRes);

        RsltBtn=findViewById(R.id.RsltBtn);
        RstBtn=findViewById(R.id.RstBtn);

        RsltBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strweg=editWgt.getText().toString();
                String strhei=editHgt.getText().toString();

                if(strweg.equals("")){
                 editWgt.setError("Please Enter Your Weight! ");
                 editWgt.requestFocus();
                 return;
                }
                if(strhei.equals("")){
                    editHgt.setError("Please Enter Your Height! ");
                    editHgt.requestFocus();
                    return;
                }
                float weight=Float.parseFloat(strweg);
                float height=Float.parseFloat(strhei)/100;

                float bmiValue=BMICalculate(weight,height);

                textInter.setText(interpretBMI(bmiValue));
                textRes.setText("BMI= "+bmiValue);

            }
        });
        RstBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editWgt.setText("");
                editHgt.setText("");
                textInter.setText("");
                textRes.setText("");

            }
        });

    }
    public float BMICalculate(float weight,float height){
        return weight/(height*height);
    }
    public String interpretBMI(float bmiValue){
        if(bmiValue<16){
            return "!!!SERVELY UNDER WEIGHT!!! \n Tips:Eat more, Sleep more...";
        }else if(bmiValue<18.5){
            return "!!!UNDER WEIGHT!!!\n Tips:Eat Healthy Food and Do Exercise Regular...";
        }else if(bmiValue<25){
            return "!!!NORMAL!!! \n Tips:Enjoy Your Life!!!";
        }else if(bmiValue<30){
            return "!!!OVERWEIGHT!!! \n Tips:Start Dieting Fast...";
        }else
   return "!!!OBESE!!! \n Tips: Tui Kotha na KOiya Khali Dowra...";
    }
}