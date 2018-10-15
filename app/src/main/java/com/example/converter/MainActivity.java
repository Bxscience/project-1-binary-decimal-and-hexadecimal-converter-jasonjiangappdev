package com.example.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText Dec;
    private EditText Bin;
    private EditText Hex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Dec = findViewById(R.id.Dec);
        Bin = findViewById(R.id.Bin);
        Hex = findViewById(R.id.Hex);
        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Dec.getText().length() > 0 && (Bin.getText().length() > 0 || Hex.getText().length() >0)
                    || Bin.getText().length() > 0 && (Dec.getText().length() > 0 || Hex.getText().length() >0)
                    || Hex.getText().length() > 0 && (Dec.getText().length() > 0 || Bin.getText().length() >0))
                    Toast.makeText(getApplicationContext(), "Please only input in one box", Toast.LENGTH_LONG).show();
                else{
                    if(Dec.getText().length() > 0)
                    {
                        String number = Dec.getText().toString();
                        Bin.setText(Integer.toString((Integer.parseInt(number,10)),2));
                        Hex.setText(Integer.toString((Integer.parseInt(number,10)),16));
                    }
                    if(Bin.getText().length() > 0)
                    {
                        String number = Bin.getText().toString();
                        boolean check = true;
                        for(int i = 0; i < number.length();i++) {
                            if (number.charAt(i) != '0' && number.charAt(i) != '1') {
                                check = false;
                                break;
                            }
                        }
                        if(check)
                        {
                            Dec.setText(Integer.toString((Integer.parseInt(number,2)),10));
                            Hex.setText(Integer.toString((Integer.parseInt(number,2)),16));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Please only input 0s and 1s for binary numbers", Toast.LENGTH_LONG).show();
                        }
                    }
                    if(Hex.getText().length() > 0)
                    {
                        String number = Hex.getText().toString();
                        boolean check = true;
                        for (int i = 0; i < number.length(); i++) {
                            if ("1234567890ABCDEFabcdef".indexOf(number.charAt(i)) == -1)
                            {
                                check = false;
                                break;
                            }
                        }
                        if(check)
                        {
                            Dec.setText(Integer.toString((Integer.parseInt(number,16)),10));
                            Bin.setText(Integer.toString((Integer.parseInt(number,16)),2));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(), "Invalid hexadecimal input, try again", Toast.LENGTH_LONG).show();
                        }
                    }
            }
        }
    });


}}