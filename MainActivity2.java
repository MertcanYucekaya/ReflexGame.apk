package com.example.reflexgame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    EditText text1;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        text1=findViewById(R.id.plainText);
        intent=new Intent(this,MainActivity.class);


    }
    public void start(View view){

        int speed = Integer.parseInt(text1.getText().toString());
        if(speed<100||speed>5000){
            Toast.makeText(MainActivity2.this,"Invalid value",Toast.LENGTH_LONG).show();

        }else {
            intent.putExtra("speed", speed);
            startActivity(intent);
        }
    }
}