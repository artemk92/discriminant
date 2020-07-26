package com.temcore.discriminant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText a;
    EditText b;
    EditText c;
    TextView result;
    Button countButt;
    Button resetButt;
    double a_d;
    double b_d;
    double c_d;
    double d;
    double i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a = findViewById(R.id.a);
        b = findViewById(R.id.b);
        c = findViewById(R.id.c);
        result = (TextView) findViewById(R.id.result);
        countButt = (Button) findViewById(R.id.count);
        resetButt = (Button) findViewById(R.id.reset);

    }

    public void onCountButtonClick(View v) {
        count();
    }

    public void onResetButtonClick(View v) {
        a.setText(null);
        b.setText(null);
        c.setText(null);
        result.setText(null);
    }

    private void count() {
        try
        {
            a_d = toNumber(a);
            b_d = toNumber(b);
            c_d = toNumber(c);
            d = b_d * b_d - 4 * a_d * c_d;
            i = Math.sqrt(d);
            if(i==0)
            {
                result.setText("x=" + (-b_d/(2 * a_d)));
            }
            else
            {
                if(i > 0)
                {
                    result.setText("x1=" + ((-b_d + i)/(2 * a_d)) + "\n" +
                            "x2=" +((-b_d-i)/(2 * a_d))
                    + "\n" + "D=" + d);
                }
                else {
                    result.setText(R.string.no);
                }
            }



        }
        catch (NumberFormatException e) {
            result.setText(R.string.error);
        }
    }
    private double toNumber(EditText view)
    {
        double res = Double.parseDouble(view.getText().toString());
        return res;
    }
}
