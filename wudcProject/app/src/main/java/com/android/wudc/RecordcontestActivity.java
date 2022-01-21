package com.android.wudc;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.android.wudc.R;
import com.android.wudc.RecordActivity;

import java.util.Date;
import java.util.List;

import static java.sql.DriverManager.println;

//공모전 활동 기록 화면
public class RecordcontestActivity extends AppCompatActivity {
    ImageButton btn_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordcontest);

        //사용할 id 연결
        btn_cancel = findViewById(R.id.btn_cancel3);

        //취소 버튼 누르면
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), RecordActivity.class);
                startActivity(intent);
            }
        });

        //DB 사용
        //SQLiteOpenHelper dbHelper;
        //DB 불러오기
        //SQLiteDatabase db = dbHelper.getReadableDatabase();
        //Cursor cursor = db.query("record",null,null,null,null,null,null);

    }
    // Load Database
    public void initLoadPersonDatabase() {

        com.example.wudc.DatabaseHelper databaseHelper = new com.example.wudc.DatabaseHelper(getApplicationContext());
        databaseHelper.OpenDatabaseFile();

        List personList = databaseHelper.getTableData();
        Log.e("test", String.valueOf(personList.size()));

        databaseHelper.close();

    }

}
