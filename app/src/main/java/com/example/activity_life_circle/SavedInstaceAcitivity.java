package com.example.activity_life_circle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SavedInstaceAcitivity extends AppCompatActivity implements View.OnClickListener {
    TextView ShowResult;
    Button Result;
    TextView Number2;
    TextView Number1;
    private int firstNumber;

    private int secondNumber;

    private int result;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Number1=findViewById(R.id.edtFirstNumber);
        Number2=findViewById(R.id.edtSecondNumber);
        Result=findViewById(R.id.btnAdd);
        ShowResult=findViewById(R.id.tvResult);
        if (savedInstanceState != null) {
            Number1.setText(String.valueOf(savedInstanceState.getInt("SO_THU_NHAT")));
            Number2.setText(String.valueOf(savedInstanceState.getInt("SO_THU_HAI")));
            ShowResult.setText(String.valueOf(savedInstanceState.getInt("KET_QUA")));
        }
        Result.setOnClickListener(this);
    }
    @Override

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!ShowResult.getText().toString().isEmpty()) {
            outState.putInt("SO_THU_NHAT", Integer.parseInt(Number1.getText().toString()));
            outState.putInt("SO_THU_HAI", Integer.parseInt(Number2.getText().toString()));
            outState.putInt("KET_QUA", Integer.parseInt(ShowResult.getText().toString()));
        }
    }
    @Override
    public void onClick(View view) {
        if (view == Result) {
            if (Number1.getText().toString().isEmpty() || Number2.getText().toString().isEmpty()) {
                Toast.makeText(this, "Vui long nhap so", Toast.LENGTH_SHORT).show();
            } else {
                firstNumber = Integer.parseInt(Number1.getText().toString());
                secondNumber = Integer.parseInt(Number2.getText().toString());
                result = firstNumber + secondNumber;
                ShowResult.setText(String.valueOf(result));
            }
        }
    }
}
