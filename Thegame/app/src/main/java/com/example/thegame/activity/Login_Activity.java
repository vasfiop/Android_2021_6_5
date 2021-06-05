package com.example.thegame.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thegame.R;
import com.example.thegame.sql.DBUtil;
import com.example.thegame.sql.Users;

public class Login_Activity extends AppCompatActivity {
    private EditText editText_name, editText_password;
    private Button btn_login, btn_register;
    private ImageButton imgbtn_back;
    private DBUtil dbUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        editText_name = findViewById(R.id.LA_edittxt_username);
        editText_password = findViewById(R.id.LA_edittxt_password);
        btn_login = findViewById(R.id.LA_btn_login);
        imgbtn_back = findViewById(R.id.LA_imgbtn_back);
        btn_register = findViewById(R.id.LA_btn_register);

        dbUtil = new DBUtil(this);
        dbUtil.open();

//        登陆事件
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String password = editText_password.getText().toString();

                Users[] users = dbUtil.select(name, password);
                if (users == null) {
                    Toast.makeText(Login_Activity.this, "账户或密码错误!", Toast.LENGTH_LONG).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("username", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

//        注册事件
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String password = editText_password.getText().toString();

                Users user = new Users(name, password);
                long position = dbUtil.insert(user);
                if (position == -1) {
                    Toast.makeText(Login_Activity.this, "error: Account add failed", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra("username", name);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

//        返回事件
        imgbtn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
