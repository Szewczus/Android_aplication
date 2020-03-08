package com.example.lab2_zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;






public class Activity0 extends AppCompatActivity {


    public static final int CODE_TRIANGLE=1;
    public static final int CODE_RECTANGLE=2;
    public static final int CODE_CIRCLE=3;
    private double area;
    private static final String LOG_TAG =
            Activity0.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        area=0.0;

        //odesłanie do strony z liczniem pol trojkata
        ((Button)findViewById(R.id.triangleButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent triangleIntent=new Intent(Activity0.this, TriangleActivity.class);//komunikacja miedzy aktywnosciami
                        startActivityForResult(triangleIntent, CODE_TRIANGLE);//wystartownie innej aktywnosci z zadaniem zwrotnym



                    }
                }
        );

        ((Button)findViewById(R.id.rectangleButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent rectangleIntent=new Intent(Activity0.this, RectangleActivity.class);
                        startActivityForResult(rectangleIntent, CODE_RECTANGLE);
                    }
                }
        );

        ((Button)findViewById(R.id.circleButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent circleIntent=new Intent(Activity0.this, CircleActivity.class);
                        startActivityForResult(circleIntent, CODE_CIRCLE);
                    }
                }
        );




        ((Button)findViewById(R.id.resetButton)).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((TextView)findViewById(R.id.resultTextView)).setText(Double.toString(0.0));
                        area=0;
                    }
                }
        );
    }




    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

            String new_area=data.getStringExtra(TriangleActivity.TRIANGLE_RESULT);
            area+=Double.parseDouble(new_area);
        ((TextView)findViewById(R.id.resultTextView)).setText(Double.toString((area)));
    }




}


