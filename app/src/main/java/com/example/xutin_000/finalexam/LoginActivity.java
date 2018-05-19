package com.example.xutin_000.finalexam;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton10;
    private RadioButton radioButton30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText1 = (EditText) findViewById(R.id.editText);
                String str21;
                String str22;
                str21 = editText1.getText().toString();
                str22 = "欢迎玩家 " + str21 + " !";

                Toast.makeText(LoginActivity.this, str22, Toast.LENGTH_SHORT).show();
                Intent intent2 = new Intent(LoginActivity.this, MainActivity.class);
                intent2.putExtra("string_data", str21);//将玩家名字传递到下一个activity
                startActivity(intent2);
            }

        });

    }
}
