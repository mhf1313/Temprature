package com.example.temperature;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    EditText editText;
    Button button;
    RadioGroup radioGroup;
    RadioButton celsius,fahrenheit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupWidget();
        onClick();
    }

    private void onClick() {
        button.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if (checkedId == R.id.celsius){
                    editText.setHint("Put No As Celsius.");
                }else if (checkedId == R.id.fahrenheit){
                    editText.setHint("Put No As Fahrenheit.");
                    Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupWidget() {
        editText = findViewById(R.id.et_degree);
        button = findViewById(R.id.btn);
        radioGroup = findViewById(R.id.box);
        celsius = findViewById(R.id.celsius);
        fahrenheit = findViewById(R.id.fahrenheit);



    }
    @Override
    public void onClick(View view) {
        String num =  editText.getText().toString();
        if(fahrenheit.isChecked())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Result");
            if (!num.isEmpty()){
                int a = Integer.parseInt(num);
                builder.setMessage((a*1.8 + 32) + " " + "fahrenheit");
                builder.setCancelable(false);
                builder.setPositiveButton("ok" , null);
                builder.show();
            }else{
                editText.setError("put Number.");
            }
        }
        else if(celsius.isChecked())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Result");
            if (!num.isEmpty()) {
                int b = Integer.parseInt(num);
                builder.setMessage(((b - 32) / 1.8) + " " + "celsius");
                builder.setCancelable(false);
                builder.setPositiveButton("ok", null);
                builder.show();
            }else{
                editText.setError("put Number.");
            }
        }
    }

}
