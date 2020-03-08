package com.example.lab2_zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

class Rectangle
{
    private double a, b;
    Rectangle(double _a, double _b)
    {
        a=_a;
        b=_b;
    }
    double area()
    {
        double p=a*b;
        return p;
    }
}



public class RectangleActivity extends AppCompatActivity {
    public final static String RECTANGLE_RESULT="Area of rectangle";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangle);

        ((Button)findViewById(R.id.rectangleCalcButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        double a=0;
                        double b=0;
                        try
                        {
                            a = Double.parseDouble(((EditText) findViewById(R.id.aEditText)).getText().toString());
                            b = Double.parseDouble(((EditText) findViewById(R.id.bEditText)).getText().toString());
                            Rectangle Rect = new Rectangle(a, b);
                            ((TextView) findViewById(R.id.rectangleResultTextView)).setText(Double.toString(Rect.area()));
                        }
                        catch (Exception e)
                        {
                            ((TextView) findViewById(R.id.rectangleResultTextView)).setText("0");
                        }
                    }
                }
        );



        ((Button)findViewById(R.id.rectangleAddButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String area_string="0";
                        if((((TextView) findViewById(R.id.rectangleResultTextView)).getText()).toString().equals("Pole prostokąta"))
                        {
                            area_string="0.0";
                        }
                        else
                        {
                            area_string=((TextView)findViewById(R.id.rectangleResultTextView)).getText().toString();
                        }


                        Intent backIntent=new Intent();
                        backIntent.putExtra(TriangleActivity.TRIANGLE_RESULT, area_string);
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );



        ((Button)findViewById(R.id.rectangleBackButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent backIntent=new Intent();
                        backIntent.putExtra(TriangleActivity.TRIANGLE_RESULT, "0.0");
                        setResult(RESULT_OK, backIntent);
                        finish();
                    }
                }
        );

    }







}
