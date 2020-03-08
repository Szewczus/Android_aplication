package com.example.lab2_zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


class Triangle
{
    private double a, b, c;
    Triangle(double _a, double _b, double _c)
    {
        a=_a;
        b=_b;
        c=_c;
    }
    double area()
    {
        double p=(a+b+c)/2.0;
        double w=(p-a)*(p-b)*(p-c)*p;
        return Math.sqrt(w);
    }
}


public class TriangleActivity extends AppCompatActivity {

    public final static String TRIANGLE_RESULT="Area of triangle";

    //***********************************************************************************************************
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle);//*********************************************************************************************************

        ((Button)findViewById(R.id.triangleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double a=0.0;
                        double b=0.0;
                        double c=0.0;
                        try {


                            a = Double.parseDouble(((EditText) findViewById(R.id.aEditText)).getText().toString());
                            b = Double.parseDouble(((EditText) findViewById(R.id.bEditText)).getText().toString());
                            c = Double.parseDouble(((EditText) findViewById(R.id.cEditText)).getText().toString());
                            if (a == 0.0 || b == 0.0 || c == 0.0) {
                                ((TextView) findViewById(R.id.triangleResultTextView)).setText("0.0");
                            }

                            if (a + b >= c && a + c >= b && b + c >= a) {
                                Triangle T = new Triangle(a, b, c);
                                ((TextView) findViewById(R.id.triangleResultTextView)).setText(Double.toString(T.area()));
                            } else {
                                ((TextView) findViewById(R.id.triangleResultTextView)).setText("0");
                            }
                        }
                        catch (Exception e)
                        {
                            ((TextView) findViewById(R.id.triangleResultTextView)).setText("0");
                        }
                    }
                }
        );

         //***********************************************************************************************************
        ((Button)findViewById(R.id.backAndAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String area_string="0";
                        if( ((TextView)findViewById(R.id.triangleResultTextView)).getText().equals("Pole trójkąta") )
                        {
                            area_string="0.0";
                        }
                        else
                        {
                            area_string=((TextView)findViewById(R.id.triangleResultTextView)).getText().toString();
                        }

                        Intent backIntent=new Intent();

                        backIntent.putExtra(TRIANGLE_RESULT, area_string);
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );

        //***********************************************************************************************************


        ((Button)findViewById(R.id.backButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent backIntent=new Intent();
                        backIntent.putExtra(TRIANGLE_RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );
        //***********************************************************************************************************

    }




}
