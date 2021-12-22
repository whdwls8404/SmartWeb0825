package com.cookandroid.p1view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

// 클릭 이벤트 리스너 등록 방법
// View.onClickListener 인터페이스 구현함.
// onClick() 메소드를 오버라이드 함.
// 클릭 이벤트를 버튼에 등록함.

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {

    private EditText editId;
    private EditText editEmail;
    private Spinner spinDomain;
    private Button btnSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editEmail = findViewById(R.id.editEmail);
        spinDomain = findViewById(R.id.spinDomain);
        btnSend = findViewById(R.id.btnSend);

        btnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        String id = editId.getText().toString();
        String emailId = editEmail.getText().toString();
        String domain = spinDomain.getSelectedItem().toString();
        String email = emailId + "@" + domain;

        if (id.isEmpty() || emailId.isEmpty()) {
            Toast.makeText(MainActivity2.this, "아이디와 이메일아이디는 필수입니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity2.this, "아이디 : " + id + ",  이메일 : " + email, Toast.LENGTH_SHORT).show();
        }
    }

}
