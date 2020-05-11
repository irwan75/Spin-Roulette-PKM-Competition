package com.example.spinroulette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class addName extends AppCompatActivity {

    Button btnLanjut;
    EditText et1, et2, et3, et4, et5, et6, et7;

    public static String[] nm = new String[7];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_name);

        btnLanjut = (Button) findViewById(R.id.btnLanjut);
        et1 = findViewById(R.id.etTim1);
        et2 = findViewById(R.id.etTim2);
        et3 = findViewById(R.id.etTim3);
        et4 = findViewById(R.id.etTim4);
        et5 = findViewById(R.id.etTim5);
        et6 = findViewById(R.id.etTim6);
        et7 = findViewById(R.id.etTim7);

        btnLanjut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm[0] = et1.getText().toString();
                nm[1] = et2.getText().toString();
                nm[2] = et3.getText().toString();
                nm[3] = et4.getText().toString();
                nm[4] = et5.getText().toString();
                nm[5] = et6.getText().toString();
                nm[6] = et7.getText().toString();

                startActivity(new Intent(addName.this, MainActivity.class));
            }
        });



    }
}
