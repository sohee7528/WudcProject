package com.android.wudc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.android.wudc.R;
import com.android.wudc.RecordActivity;

//일상 활동 기록 화면
public class RecorddayActivity extends AppCompatActivity {
    ImageButton btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordday);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel4);

        //취소 버튼 누르면
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), RecordActivity.class);
                startActivity(intent);
            }
        });
    }
}
