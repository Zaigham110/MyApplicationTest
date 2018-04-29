package com.example.viran.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    private CheckBox morning, noon, evening;
    private EditText address;
    private Button confirmAdd, btnProceed;
    AlertDialog b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        morning = findViewById(R.id.cb_morning);
        noon = findViewById(R.id.cb_noon);
        evening = findViewById(R.id.cb_evening);
        btnProceed = findViewById(R.id.btn_proceed);
        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddressDialog();
            }
        });

        checkBoxMarking();
    }

    private void checkBoxMarking() {

        morning.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (morning.isChecked()){
                    noon.setChecked(false);
                    evening.setChecked(false);
                }
            }
        });

        noon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (noon.isChecked()){
                    morning.setChecked(false);
                    evening.setChecked(false);
                }
            }
        });

        evening.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (evening.isChecked()){
                    morning.setChecked(false);
                    noon.setChecked(false);
                }
            }
        });
    }

    private void showAddressDialog() {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.address_input_dialog, null);
        dialogBuilder.setView(dialogView);

        address = findViewById(R.id.edt_address);
        confirmAdd = findViewById(R.id.btn_confirmAdd);

        b = dialogBuilder.create();
        b.show();

        btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BookingActivity.this, ConfirmationActivity.class);
                startActivity(i);

            }
        });


    }

}
