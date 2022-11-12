package com.example.randomcolor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Random rnd = new Random();
        sharedpreferences = getSharedPreferences("ColorPrefs", Context.MODE_PRIVATE);
        button = (Button) findViewById(R.id.button);
        button.setBackgroundColor(sharedpreferences.getInt("colorBackgroundKey", 0));
        button.setBackgroundColor(sharedpreferences.getInt("colorTextKey", 0));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int colorBackground = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                int colorText = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                button.setBackgroundColor(colorBackground);
                button.setTextColor(colorText);
                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putInt("colorBackgroundKey", colorBackground);
                editor.putInt("colorTextKey", colorText);
                editor.commit();
            }
        });
    }

}