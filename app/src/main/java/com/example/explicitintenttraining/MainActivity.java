package com.example.explicitintenttraining;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputData;
    Button btn2, btn3;
    TextView results;
    final int ACTIVITY_3 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn2 = findViewById(R.id.act2Btn);
        btn3 = findViewById(R.id.act3Btn);
        inputData = findViewById(R.id.etname);
        results = findViewById(R.id.tvResult);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputData.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Please input data", Toast.LENGTH_LONG).show();
                }else{
                    String name = inputData.getText().toString().trim();
                    Intent intent = new Intent(MainActivity.this, Activity2.class);
                    intent.putExtra("data",name);
                    startActivity(intent);

                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity3.class);

                startActivityForResult(intent, ACTIVITY_3);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==ACTIVITY_3){
            if(resultCode==RESULT_OK){
                results.setText(data.getStringExtra("surname"));
            }
            if(resultCode==RESULT_CANCELED){
                results.setText("No data received");
            }
        }

    }
}