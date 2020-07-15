package com.example.engeneering_school_test1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class CaculatorActivity extends AppCompatActivity {

    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    Button btnC, reverse, dot, mod, divine, multi, minus, plus, result;
    TextView mainText = null;
    boolean first_time = true;
    boolean catchDot = false;
    float   container_value1 = 0, container_value2 = 0;
    // -1 : error
    // 0 : mod
    // 1 : divine
    // 2 : multi
    // 3 : minus
    // 4 : plus
    int     state_operator = -1;
    DecimalFormat decimal = new DecimalFormat("0.######");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caculator);

        // Find ID

        mainText = findViewById(R.id.mainText);

        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        btnC = findViewById(R.id.btnC);
        reverse = findViewById(R.id.reverse);
        dot = findViewById(R.id.dot);
        mod = findViewById(R.id.mod);
        divine = findViewById(R.id.divine);
        multi = findViewById(R.id.multi);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        result = findViewById(R.id.result);

        // Listener
        Button.OnClickListener onClickListener = new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first_time) {
                    first_time = false;
                    mainText.setText("");
                }

                if (container_value2 != 0)
                {
                    state_operator = -1;
                    Caculate();
                }
                else {
                    String tempText;
                    float tempFloat;

                    switch (view.getId()) {
                        case R.id.btn0:
                            tempText = mainText.getText().toString() + "0";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn1:
                            tempText = mainText.getText().toString() + "1";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn2:
                            tempText = mainText.getText().toString() + "2";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn3:
                            tempText = mainText.getText().toString() + "3";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn4:
                            tempText = mainText.getText().toString() + "4";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn5:
                            tempText = mainText.getText().toString() + "5";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn6:
                            tempText = mainText.getText().toString() + "6";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn7:
                            tempText = mainText.getText().toString() + "7";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn8:
                            tempText = mainText.getText().toString() + "8";
                            mainText.setText(tempText);
                            break;
                        case R.id.btn9:
                            tempText = mainText.getText().toString() + "9";
                            mainText.setText(tempText);
                            break;
                            //
                        case R.id.btnC:
                            first_time = true;
                            mainText.setText("0");
                            break;
                        case R.id.reverse:
                            if (mainText.getText().toString() == "" && state_operator == -1) {
                                mainText.setText(Float.toString(container_value1));
                            }
                            else {
                                mainText.setText(Float.toString(container_value2));
                            }

                            tempFloat = Float.parseFloat(mainText.getText().toString()) * (-1.0f);
                            tempText = Float.toString(tempFloat);
                            mainText.setText(tempText);
                            break;
                        case R.id.dot:
                            if (catchDot) {
                                catchDot = false;
                                state_operator = -1;
                                Caculate();
                            }
                            else {
                                catchDot = true;

                                if (mainText.getText().toString() == "") {
                                    mainText.setText("0");
                                }
                                tempText = mainText.getText().toString() + ".";
                                mainText.setText(tempText);
                            }
                            break;
                        case R.id.mod:
                            first_time = true;
                            catchDot = false;

                            if (mainText.getText().toString() == "") {
                                mainText.setText(Float.toString(container_value1));
                            }

                            container_value1 = Float.parseFloat(mainText.getText().toString());
                            state_operator = 0;
                            mainText.setText("%");
                            break;
                        case R.id.divine:
                            first_time = true;
                            catchDot = false;

                            if (mainText.getText().toString() == "") {
                                mainText.setText(Float.toString(container_value1));
                            }

                            container_value1 = Float.parseFloat(mainText.getText().toString());
                            state_operator = 1;
                            mainText.setText("/");
                            break;
                        case R.id.multi:
                            first_time = true;
                            catchDot = false;

                            if (mainText.getText().toString() == "") {
                                mainText.setText(Float.toString(container_value1));
                            }

                            container_value1 = Float.parseFloat(mainText.getText().toString());
                            state_operator = 2;
                            mainText.setText("x");
                            break;
                        case R.id.minus:
                            first_time = true;
                            catchDot = false;

                            if (mainText.getText().toString() == "") {
                                mainText.setText(Float.toString(container_value1));
                            }

                            container_value1 = Float.parseFloat(mainText.getText().toString());
                            state_operator = 3;
                            mainText.setText("-");
                            break;
                        case R.id.plus:
                            first_time = true;
                            catchDot = false;

                            if (mainText.getText().toString() == "") {
                                mainText.setText(Float.toString(container_value1));
                            }

                            container_value1 = Float.parseFloat(mainText.getText().toString());
                            state_operator = 4;
                            mainText.setText("+");
                            break;
                        case R.id.result:
                            if (mainText.getText().toString() == "") {
                                state_operator = -1;
                            }
                            else {
                                container_value2 = Float.parseFloat(mainText.getText().toString());
                            }

                            Caculate();
                            break;
                    }
                }
            }
        } ;

        // Set Listener
        btn0.setOnClickListener(onClickListener);
        btn1.setOnClickListener(onClickListener);
        btn2.setOnClickListener(onClickListener);
        btn3.setOnClickListener(onClickListener);
        btn4.setOnClickListener(onClickListener);
        btn5.setOnClickListener(onClickListener);
        btn6.setOnClickListener(onClickListener);
        btn7.setOnClickListener(onClickListener);
        btn8.setOnClickListener(onClickListener);
        btn9.setOnClickListener(onClickListener);
        btnC.setOnClickListener(onClickListener);
        reverse.setOnClickListener(onClickListener);
        dot.setOnClickListener(onClickListener);
        mod.setOnClickListener(onClickListener);
        divine.setOnClickListener(onClickListener);
        multi.setOnClickListener(onClickListener);
        minus.setOnClickListener(onClickListener);
        plus.setOnClickListener(onClickListener);
        result.setOnClickListener(onClickListener);
    }

    private void Caculate() {
        float   total = 0;

        switch(state_operator) {
            case -1:
                mainText.setText("ERROR");
                break;
            case 0:
                total = container_value1 % container_value2;
                mainText.setText(decimal.format(total));
                break;
            case 1:
                if (container_value2 == 0) {
                    mainText.setText("DIVINEZERO");
                }
                else {
                    total = container_value1 / container_value2;
                    mainText.setText(decimal.format(total));
                }
                break;
            case 2:
                total = container_value1 * container_value2;
                mainText.setText(decimal.format(total));
                break;
            case 3:
                total = container_value1 - container_value2;
                mainText.setText(decimal.format(total));
                break;
            case 4:
                total = container_value1 + container_value2;
                mainText.setText(decimal.format(total));
                break;
        }

        first_time = true;
        catchDot = false;
        state_operator = -1;
        container_value1 = total;
        container_value2 = 0;
    }
}
