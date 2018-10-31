package com.example.rahul.sampleproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;

import android.view.View;

import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.appyvet.materialrangebar.RangeBar;

public class MainActivity extends AppCompatActivity {

    SwitchCompat manSwitch,womenSwitch,matchmaker;
    ImageView backButton;
    RangeBar rangeBar;
    TextView age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manSwitch=findViewById(R.id.manSwitch);
        womenSwitch=findViewById(R.id.womenSwitch);
        rangeBar=findViewById(R.id.bar);
        age=findViewById(R.id.age);
        matchmaker=findViewById(R.id.hideSwitch);
        backButton=findViewById(R.id.backButton);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        manSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                {
                    if(!womenSwitch.isChecked())
                    womenSwitch.setChecked(true);
                }
            }
        });
        womenSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(!b)
                {
                    if(!manSwitch.isChecked())
                    manSwitch.setChecked(true);
                }
            }
        });
        rangeBar.setOnRangeBarChangeListener(new RangeBar.OnRangeBarChangeListener() {
            @Override
            public void onRangeChangeListener(RangeBar rangeBar, int leftPinIndex, int rightPinIndex, String leftPinValue, String rightPinValue) {
                if(leftPinIndex<rightPinIndex)
                {
                    age.setText(""+leftPinValue+"-"+rightPinValue);
                }
                else{
                    age.setText(""+rightPinValue+"-"+leftPinValue);
                }
            }
        });
    }
}
