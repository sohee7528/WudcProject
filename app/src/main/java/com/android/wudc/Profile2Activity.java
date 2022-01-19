package com.android.wudc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Profile2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);

        EditText name = findViewById(R.id.name);
        ImageButton false1 = findViewById(R.id.false1);
        ImageButton true1 = findViewById(R.id.true1);
        ImageButton tab2 = findViewById(R.id.tab2);

        //profile에서 이름 받아오기
        Intent inIntent = getIntent();
        String Name = inIntent.getStringExtra("Name");
        name.setText(Name);


        false1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), ProfileActivity.class);
                outIntent.putExtra("Name",name.toString());
                setResult(RESULT_OK,outIntent);
                Toast.makeText(getApplicationContext(),"수정 완료!", Toast.LENGTH_SHORT).show();
            }
        });
/*
        tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile2Activity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });*/
    }
}