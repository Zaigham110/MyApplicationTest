package com.example.viran.myapplication;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btn_verify;
    private TextInputLayout layout_otp;
    private EditText edt_otp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_verify = findViewById(R.id.btn_verify);
        layout_otp = findViewById(R.id.layout_otp);
        edt_otp = findViewById(R.id.edt_otp);

        btn_verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout_otp.setVisibility(View.VISIBLE);
                btn_verify.setText("GO");
                Intent i = new Intent(getApplicationContext(), NextActivity.class);
                startActivity(i);

            }
        });
    }
}
