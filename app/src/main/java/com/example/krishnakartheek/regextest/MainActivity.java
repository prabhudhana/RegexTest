package com.example.krishnakartheek.regextest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    boolean isValidFlag=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText=(EditText)findViewById(R.id.edt_test);
        String data=editText.getText().toString();

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(isValidName(editable.toString())) {
                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Not Success", Toast.LENGTH_SHORT).show();
                }


            }
        });


    }
    public final static boolean isValidPassword(String target) {
        return Pattern.compile("^(?=.*\\d)(?=.*[a-zA-Z])[a-zA-Z0-9]{4,12}$").matcher(target).matches();
    }

    public final static boolean isValidName(String target) {
        return Pattern.compile("^(?=.*[a-zA-Z])[a-zA-Z]{1,}$").matcher(target).matches();

    }

    public final static boolean isValidNickName(String target) {
        return Pattern.compile("^(?=.*[a-zA-Z\\d])[a-zA-Z0-9가-힣]{2,12}$|^[가-힣]$").matcher(target).matches();
    }
}
