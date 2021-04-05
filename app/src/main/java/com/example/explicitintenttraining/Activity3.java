package com.example.explicitintenttraining;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText inputName;
    Button submit, cancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        inputName = findViewById(R.id.inputName);
        submit = findViewById(R.id.submitBtn);
        cancel = findViewById(R.id.cancel);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputName.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this, "input data", Toast.LENGTH_SHORT).show();
                }else{
                    String surname = inputName.getText().toString().trim();
                    Intent intent = new Intent();
                    intent.putExtra("surname", surname);
                    setResult(RESULT_OK, intent);
                    Activity3.this.finish();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 setResult(RESULT_CANCELED);
                 Activity3.this.finish();
            }
        });
    }
}