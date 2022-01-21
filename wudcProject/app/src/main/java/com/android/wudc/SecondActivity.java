package com.android.wudc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.wudc.R;

public class SecondActivity extends AppCompatActivity {

    ImageButton falsebtn;
    ImageButton truebtn;
    ImageButton class_btn, club_btn, day_btn, contest_btn;

    TextView selectedDate, club_name, contents, thoughts;
    String name, content, thought;

    private final int Fragment_1 = 1; //
    private final int Fragment_2 = 2; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        club_name = findViewById(R.id.club_name);
        contents = findViewById(R.id.contents);
        thoughts = findViewById(R.id.thoughts);

        // 선택된 날짜 명시 (인텐트 사용)
        selectedDate = findViewById(R.id.selectedDate);
        Intent intent = getIntent();
        String date = intent.getExtras().getString("selectedDate");
        selectedDate.setText(date);

        // 버튼 변수 설정
        falsebtn = findViewById(R.id.falsebtn);
        truebtn = findViewById(R.id.truebtn);

        class_btn = findViewById(R.id.class_btn);
        club_btn = findViewById(R.id.club_btn);
        day_btn = findViewById(R.id.day_btn);
        contest_btn = findViewById(R.id.contest_btn);

        // 뒤로가기, 저장 버튼 설정해야 함
        falsebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(intent.hasExtra("todayrecord")) {
            selectedDate.setText(intent.getStringExtra("todayrecord"));
        } else {
            Toast.makeText(this,"Error!", Toast.LENGTH_SHORT).show();
        }

        //저장버튼 누르면 데이터 전달, 활동기록 화면으로 이동
        truebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Object todaydate = selectedDate.getText();
                SharedPreferences sharedPreferences = getSharedPreferences("$todaydate", 0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                name = club_name.getText().toString();
                editor.putString("name", club_name.getText().toString());
                editor.putString("contents", contents.getText().toString());
                editor.putString("thoughts", thoughts.getText().toString());


                Intent intent = new Intent(getApplicationContext(),RecordActivity.class);
                intent.putExtra("date", (Bundle) todaydate);
                startActivity(intent);
            }
        });

        // 이 아래부터 프래그먼트
        class_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest2);
                FragmentView(Fragment_1);
            }
        });

        club_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest2);

                FragmentView(Fragment_1);
            }
        });

        day_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday);
                contest_btn.setImageResource(R.drawable.buttoncontest2);

                FragmentView(Fragment_1);
            }
        });

        contest_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                class_btn.setImageResource(R.drawable.buttonclass2);
                club_btn.setImageResource(R.drawable.buttonclub2);
                day_btn.setImageResource(R.drawable.buttonday2);
                contest_btn.setImageResource(R.drawable.buttoncontest);

                FragmentView(Fragment_1);
            }
        });

        FragmentView(Fragment_1);
        



    }

    private void FragmentView(int fragment) {

        // FragmentTransaction 통해 프래그먼트 사용하기
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch(fragment) {
            case 1: // 첫번째 프래그먼트 호출
                ClassFragment classFragment = new ClassFragment();
                transaction.replace(R.id.frame_layout, classFragment);
                transaction.commit();
                break;

            case 2: // 두번째 프래그먼트 호출
                ClubFragment clubFragment = new ClubFragment();
                transaction.replace(R.id.frame_layout, clubFragment);
                transaction.commit();
                break;

            case 3:
        }
    }
}