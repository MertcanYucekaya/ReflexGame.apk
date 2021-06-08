package com.example.reflexgame2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    ImageView image1;
    ImageView image2;
    ImageView image3;
    ImageView image4;
    ImageView image5;
    ImageView image6;
    ImageView image7;
    ImageView image8;
    ImageView image9;
    ImageView imager1;
    ImageView imager2;
    ImageView imager3;
    ImageView imager4;
    ImageView imager5;
    ImageView imager6;
    ImageView imager7;
    ImageView imager8;
    ImageView imager9;
    Handler handler;
    Runnable runnable;
    ImageView[] array;
    int score;
    int storeds;
    SharedPreferences sharedPreferences;
    Intent intent;
    Random random = new Random();
    int randomk = random.nextInt(8);
    int sk=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1 = findViewById(R.id.text1);
        sharedPreferences= this.getSharedPreferences("com.example.reflexgame2", Context.MODE_PRIVATE);
        text2= findViewById(R.id.stext2);
        intent = getIntent();
        image1 = findViewById(R.id.imageView1);
        image2 = findViewById(R.id.imageView2);
        image3 = findViewById(R.id.imageView3);
        image4 = findViewById(R.id.imageView4);
        image5 = findViewById(R.id.imageView5);
        image6 = findViewById(R.id.imageView6);
        image7 = findViewById(R.id.imageView7);
        image8 = findViewById(R.id.imageView8);
        image9 = findViewById(R.id.imageView9);
        imager1 = findViewById(R.id.imageViewr1);
        imager2 = findViewById(R.id.imageViewr2);
        imager3 = findViewById(R.id.imageViewr3);
        imager4 = findViewById(R.id.imageViewr4);
        imager5 = findViewById(R.id.imageViewr5);
        imager6 = findViewById(R.id.imageViewr6);
        imager7 = findViewById(R.id.imageViewr7);
        imager8 = findViewById(R.id.imageViewr8);
        imager9 = findViewById(R.id.imageViewr9);

        array = new ImageView[]{image1, image2, image3, image4, image5, image6, image7, image8, image9,
                imager1, imager2, imager3, imager4, imager5, imager6, imager7, imager8, imager9};
        score = 0;
        hideImage();
        text2.setText("Best score : "+sharedPreferences.getInt("storeds",0));




    }
    public void green(View view) {
        score++;
        text1.setText("Score : " + score);

    }
    public void red(View view) {
        storeds=sharedPreferences.getInt("storeds",0);
        if(storeds<score){
            sharedPreferences.edit().putInt("storeds",score).apply();


        }
        handler.removeCallbacks(runnable);
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle("Restart");
        alert.setMessage("Do you want to play again?");
        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent intent = getIntent();
                finish();
                startActivity(intent);

            }
        });
        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();

    }



    public void hideImage() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                for (ImageView i : array) {
                    i.setVisibility(View.INVISIBLE);
                }
                
                int x = random.nextInt(8);
                sk++;
                if(sk>=randomk){
                    x=x+9;
                    randomk=random.nextInt(8);
                    sk=0;
                }
                array[x].setVisibility(View.VISIBLE);
                handler.postDelayed(this, intent.getIntExtra("speed",0));


            }
        };
        handler.post(runnable);
    }
}