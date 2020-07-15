package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RadioActivity extends AppCompatActivity {

    @BindView(R.id.rBtn_bread) RadioButton rBtn_bread;
    @BindView(R.id.rBtn_rice) RadioButton rBtn_rice;
    @BindView(R.id.rGroup) RadioGroup rGroup;
    @BindView(R.id.switch1) Switch switch1;
    @BindView(R.id.checkBox1) CheckBox checkBox1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        ButterKnife.bind(this);

        rBtn_bread.setOnClickListener(radioButtonClickListener);
        rBtn_rice.setOnClickListener(radioButtonClickListener);
        rGroup.setOnCheckedChangeListener(radioGroupCheckedChangeListener);
        switch1.setOnCheckedChangeListener(switchCheckedChangeListener);
        checkBox1.setOnClickListener(checkBoxOnClickListener);
    }

    private RadioButton.OnClickListener radioButtonClickListener = new RadioButton.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.rBtn_rice :
                    Toast.makeText(getApplicationContext(), "버튼_밥", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rBtn_bread :
                    Toast.makeText(getApplicationContext(), "버튼_빵", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private RadioGroup.OnCheckedChangeListener radioGroupCheckedChangeListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rGroup_rice :
                    Toast.makeText(getApplicationContext(), "그룹_밥", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.rGroup_bread :
                    Toast.makeText(getApplicationContext(), "그룹_빵", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    private Switch.OnCheckedChangeListener switchCheckedChangeListener = new Switch.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                Toast.makeText(getApplicationContext(), "ONON", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "OFFOFF", Toast.LENGTH_SHORT).show();
            }
        }
    };

    private CheckBox.OnClickListener checkBoxOnClickListener = new Switch.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (((CheckBox)v).isChecked()) {
                Toast.makeText(getApplicationContext(), "Check", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "None", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
