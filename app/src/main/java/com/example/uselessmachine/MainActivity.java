package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 private Switch uslessSwitch;
 private Button selfDistruct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();

    }
    private void setListeners() {
    uslessSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if(isChecked) {
                new CountDownTimer(2000, 10) {
                    @Override
                    public void onTick(long l) {
                        if(!uslessSwitch.isChecked()){
                            cancel();
                        }
                    }

                    @Override
                    public void onFinish() {
                        uslessSwitch.setChecked(false);
                    }
                }.start();
            }
//
//            if(isChecked) {
//               Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();
//           }
//           else {
//               Toast.makeText(MainActivity.this, "OFF", Toast.LENGTH_SHORT).show();
//           }

        }
    });
    selfDistruct.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    });

    }
    private void wireWidgets() {
uslessSwitch = findViewById(R.id.switch_main);
selfDistruct = findViewById(R.id.button_main_selfdistruct);
    }
}

