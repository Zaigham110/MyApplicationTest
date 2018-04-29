package com.example.viran.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {

    private Button conti;
    private CheckBox agree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        conti = findViewById(R.id.btn_conti);
        agree = findViewById(R.id.cb_agree);

        agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (agree.isChecked()){
                    conti.setEnabled(true);
                } else {
                    conti.setEnabled(false);
                }
            }
        });

        conti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(NextActivity.this, BookingActivity.class);
                startActivity(i);
            }
        });

    }
}
