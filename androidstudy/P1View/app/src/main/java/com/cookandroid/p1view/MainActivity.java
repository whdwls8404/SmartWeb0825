package com.cookandroid.p1view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // field
    private EditText editId;  // 객체명은 자유이지만, 해당 위젯의 id로 맞춰서 사용
    private EditText editEmail;
    private Spinner spinDomain;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 위젯을 해당 ID로 연결
        editId = findViewById(R.id.editId);
        editEmail = findViewById(R.id.editEmail);
        spinDomain = findViewById(R.id.spinDomain);
        btnSend = findViewById(R.id.btnSend);

        // btnSend를 클릭하면 동작할 코드
        // View.onClickListener : 이벤트 리스너 (객체)
        // onClick() : 메소드

        // 작업순서
        // 1. btnSend에 클릭 이벤트리스너를 등록시킨다. (객체 생성해서 등록)
        // 2. 등록된 이벤트리스너에 onClick() 메소드를 추가한다.

       btnSend.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               // Editable editable = editId.getText();
               // String id = editable.toString();
               // 위 코드는 대부분 아래와 같이 작업
               // trim() : 앞 뒤 공백 제거 (선택 사항)
               String id = editId.getText().toString().trim();

               if (id.isEmpty()) {
                   Toast.makeText(MainActivity.this, "아이디를 입력하세요.", Toast.LENGTH_SHORT).show();
               } else {
                   Toast.makeText(MainActivity.this, "아이디 : " + id, Toast.LENGTH_SHORT).show();
               }

           }
       });







    }

}