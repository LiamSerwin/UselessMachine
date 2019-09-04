package com.example.uselessmachine;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Switch uslessSwitch;
    private Button selfDistruct;
    private Button lookBusy;
    private ConstraintLayout constraintLayout;
    private ProgressBar busyBar;

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
                if (isChecked) {
                    new CountDownTimer(2000, 10) {
                        @Override
                        public void onTick(long l) {
                            if (!uslessSwitch.isChecked()) {
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
                new CountDownTimer(10000, 1000) {

                    int i = 10;

                    @Override
                    public void onTick(long l) {
                        i--;
                        selfDistruct.setText(String.valueOf(i));
                        changeBackgroundColor();

                    }

                    @Override
                    public void onFinish() {
                        finish();
                    }
                }.start();

            }
        });

        lookBusy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                busyBar.setVisibility(View.VISIBLE);
                selfDistruct.setVisibility(View.INVISIBLE);
                uslessSwitch.setVisibility(View.INVISIBLE);
                lookBusy.setVisibility(View.INVISIBLE);
                new CountDownTimer(10000, 100) {
                    int value = 0;

                    @Override
                    public void onTick(long l) {
                        busyBar.setProgress(value);
                        value++;
                    }

                    @Override
                    public void onFinish() {
                        selfDistruct.setVisibility(View.VISIBLE);
                        uslessSwitch.setVisibility(View.VISIBLE);
                        lookBusy.setVisibility(View.VISIBLE);
                        busyBar.setVisibility(View.INVISIBLE);
                    }
                }.start();


            }
        });

    }

    private void wireWidgets() {
        uslessSwitch = findViewById(R.id.switch_main);
        selfDistruct = findViewById(R.id.button_main_selfdistruct);
        constraintLayout = findViewById(R.id.constraint_layout_main);
        lookBusy = findViewById(R.id.button_main_busy);
        busyBar = findViewById(R.id.progressbar_main_busy);


    }

    private void changeBackgroundColor() {
        int r = 255;
        int g = 0;
        int b = 0;
        constraintLayout.setBackgroundColor(Color.rgb(r, b, g));
    }
}

