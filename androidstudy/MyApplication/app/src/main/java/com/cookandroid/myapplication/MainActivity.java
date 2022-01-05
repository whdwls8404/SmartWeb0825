package com.cookandroid.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //field
    private EditText editId;
    private EditText editPw;
    private EditText editEmail;
    private Button btnSend;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editPw = findViewById(R.id.editPw);
        editEmail = findViewById(R.id.editEmail);
        btnSend = findViewById(R.id.btnSend);


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String id = editId.getText().toString().trim();
                String pw = editPw.getText().toString().trim();
                String email = editEmail.getText().toString().trim();

                if (id.isEmpty() || pw.isEmpty()) {
                    Toast.makeText(MainActivity.this, "잘못된 비밀번호입니다.", Toast.LENGTH_SHORT).show();
                }

                if (id.isEmpty() || email.isEmpty()) {
                    Toast.makeText(MainActivity.this, "아이디와 이메일 아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this,  "입력된 id는 : " + id + ", 이메일 : " + email + "입니다.", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}