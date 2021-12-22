package com.cookandroid.p2view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editId;
    private EditText editPw;
    private RadioGroup radioGroupGender;
    private RadioButton radioButtonMale;
    private RadioButton radioButtonFemale;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private Button btnJoin;

    @Override
    public void onClick(View view) {  // view로 클릭한 객체가 전달됨.

        // btnJoin을 클릭했는지 확인하는 코드
        if (view.getId() == R.id.btnJoin) {

        }
        switch (view.getId()) {
            case R.id.btnJoin:
                break;
        }

        // 입력 값 모으는 message
        String message = "";

        // 입력 및 선택
        String id = editId.getText().toString();
        message += "아이디 : " + id + "\n";
        String pw = editPw.getText().toString();
        message += "비밀번호 : " + pw + "\n";
        int genderId = radioGroupGender.getCheckedRadioButtonId();
        switch (genderId) {
            case R.id.radioButtonMale:
                message += "성별 : 남자\n";
                break;
            case R.id.radioButtonFemale:
                message += "성별 : 여자\n";
                break;
        }
        int checkResult = 0;
        if (checkBox1.isChecked()) {
            checkResult += 1;
        }
        if (checkBox2.isChecked()) {
            checkResult += 2;
        }
        if (checkBox3.isChecked()) {
            checkResult += 4;
        }
        switch (checkResult) {
            case 0: message += "관심사 : 없음\n"; break;
            case 1: message += "관심사 : 자바\n"; break;
            case 2: message += "관심사 : 안드로이드\n"; break;
            case 3: message += "관심사 : 자바, 안드로이드\n"; break;
            case 4: message += "관심사 : 스프링\n"; break;
            case 5: message += "관심사 : 자바, 스프링\n"; break;
            case 6: message += "관심사 : 안드로이드, 스프링\n"; break;
            case 7: message += "관심사 : 자바, 안드로이드, 스프링\n"; break;
        }
        /*
        String check1 = checkBox1.getText().toString();
        String check2 = checkBox2.getText().toString();
        String check3 = checkBox3.getText().toString();
        */

        // Toast
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editId = findViewById(R.id.editId);
        editPw = findViewById(R.id.editPw);
        radioGroupGender = findViewById(R.id.radioGroupGender);
        radioButtonMale = findViewById(R.id.radioButtonMale);
        radioButtonFemale = findViewById(R.id.radioButtonFemale);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        btnJoin = findViewById(R.id.btnJoin);

        btnJoin.setOnClickListener(this);
    }

}