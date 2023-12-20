package com.example.srs7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity5 extends AppCompatActivity {
 EditText number,number2,number3,number4;
 int nober = 0;
 TextView tvtimer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        tvtimer = findViewById(R.id.textView19);
        number = findViewById(R.id.editTextNumber2);
        number2 = findViewById(R.id.editTextNumber4);
        number3 = findViewById(R.id.editTextNumber5);
        number4 = findViewById(R.id.editTextNumber6);
        addAutoMoveTONExtEditText(number,number2,number);
        addAutoMoveTONExtEditText(number2,number3,number);
        addAutoMoveTONExtEditText(number3,number4,number2);
        addAutoMoveTONExtEditText(number4,number4,number3);
        Timer();

    }

    private void addAutoMoveTONExtEditText(final EditText current,final EditText next, final EditText Forerunner) {
        current.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length()==1){
                    next.requestFocus();
                    nober++;
                    generatepassword(nober);

                }
                else{Forerunner.requestFocus();nober--;}
                generatepassword(nober);
            }
        });
    }
    public void Timer(){
        new CountDownTimer(60000,1000){
            @SuppressLint("SetTextO18n")
            public void onTick(long millisUntilFinished){
                tvtimer.setText("Отправить код повторно можно будет через" +millisUntilFinished/1000+"секунд");
            }
            public void onFinish(){
                tvtimer.setText("Можете запросить новый код");
            }
        }.start();
    }
    public void generatepassword(int nober){
        if (nober == 4){
            Intent intent = new Intent(MainActivity5.this, MainActivity6.class);
            startActivity(intent);
        }
    }
}