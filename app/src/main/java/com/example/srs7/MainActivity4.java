package com.example.srs7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener {
 private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        btn = findViewById(R.id.button);
        btn.setOnClickListener(this);
        ValidationEmail validator = new ValidationEmail();
        btn.setEnabled(false);
        btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C9D4FB")));
        EditText editText = findViewById(R.id.editTextTextEmailAddress);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn.setEnabled(false);
                btn.getBackground();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                btn.setEnabled(false);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String inputText = editable.toString();
                if(validator.validate(inputText))
                {
                    btn.setEnabled(true);
                    btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#1A6FEE")));
                    btn.setTextColor(ColorStateList.valueOf(Color.WHITE));
                }
                else
                {
                    btn.setEnabled(false);
                    btn.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#C9D4FB")));
                }
            }
        });

    }

    @Override
    public void onClick(View view)
    {
        Intent intent = new Intent(this,MainActivity5.class);
        startActivity(intent);
    }
}