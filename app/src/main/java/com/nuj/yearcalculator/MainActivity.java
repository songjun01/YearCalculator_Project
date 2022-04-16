package com.nuj.yearcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editNumber;
    final int REQUEST_CHANGE = 1001;
    public String year;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNumber=findViewById(R.id.idEditNumber);
    }
    public void onCalculateClicked(View v){
        if(editNumber.getText().toString().length() != 0) {
            year = editNumber.getText().toString();
            Intent intent = new Intent(this, ViewActivity.class);
            intent.putExtra("my_year", year);
            startActivityForResult(intent, REQUEST_CHANGE);
        }
        else {
            Toast.makeText(this, "연도를 입력해 주세요", Toast.LENGTH_SHORT).show();
        }
    }
}