package com.example.converterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText text;
    TextView txt;
    TextView txt2;
    Button btn;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.editTextTextPersonName);
        txt = findViewById(R.id.textView2);
        txt2 = findViewById(R.id.textView3);
        btn = findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        ArrayList<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("MAD");
        spinnerArray.add("DOLLAR");
        spinnerArray.add("EURO");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View view, int arg2, long arg3) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String selected = spinner.getSelectedItem().toString();
                double number = Double.parseDouble(text.getText().toString());
                if (selected=="MAD"){
                    double dollar = number * 0.098;
                    double euro = number * 0.090;
                    txt.setText(dollar + " DOLLAR");
                    txt2.setText(euro + " EURO");
                } else if (selected=="DOLLAR") {
                    double mad = number * 10.46;
                    double euro = number * 0.95;
                    txt.setText(mad + " MAD");
                    txt2.setText(euro + " EURO");
                } else if (selected=="EURO") {
                    double mad = number * 11.06;
                    double dollar = number * 1.06;
                    txt.setText(mad + " MAD");
                    txt2.setText(dollar + " DOLLAR");
                }
                //Toast.makeText(this,selected,Toast.LENGTH_SHORT).show();
            }
        });

    }
}