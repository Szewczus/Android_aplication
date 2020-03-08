package com.example.lab2_zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.xml.transform.Result;

class Circle
{
    private double r;
    Circle(double _r)
    {
        r=_r;
    }

    double area()
    {
        double p=Math.PI*Math.pow(this.r,2);
        return p;
    }
}



public class CircleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);


        ((Button)findViewById(R.id.circleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double r=0;
                        try
                        {
                            r = Double.parseDouble(((EditText) findViewById(R.id.rEditText)).getText().toString());
                            Circle C = new Circle(r);
                            ((TextView) findViewById(R.id.CircleResultTextView)).setText(Double.toString(C.area()));
                        }
                        catch (Exception e)
                        {
                            ((TextView) findViewById(R.id.CircleResultTextView)).setText("0.0");
                        }
                    }
                }
        );


        ((Button)findViewById(R.id.circleBackButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent backIntent=new Intent();
                        backIntent.putExtra(TriangleActivity.TRIANGLE_RESULT, "0.0");
                        setResult(TriangleActivity.RESULT_OK, backIntent);
                        finish();
                    }
                }
        );


        ((Button)findViewById(R.id.circleAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String area_new="0";

                         if((((TextView) findViewById(R.id.CircleResultTextView)).getText()).toString().equals("Pole koła"))
                         {
                             area_new="0.0";
                         }
                         else
                         {
                             area_new=((TextView)findViewById(R.id.CircleResultTextView)).getText().toString();
                         }



                        Intent backIntent=new Intent();
                        backIntent.putExtra(TriangleActivity.TRIANGLE_RESULT, area_new);
                        setResult(TriangleActivity.RESULT_OK, backIntent);
                        finish();

                    }
                }
        );



    }
}
