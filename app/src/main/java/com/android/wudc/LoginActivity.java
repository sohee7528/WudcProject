package com.android.wudc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import de.hdodenhof.circleimageview.CircleImageView;

public class LoginActivity extends AppCompatActivity {

    private final int REQUEST_CODE = 200;
    private CircleImageView profileImage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        profileImage = findViewById(R.id.profileImage);
        ImageButton true1 = findViewById(R.id.true1);
        EditText name = findViewById(R.id.name);

        //String nameLength = name.getText().toString();

        true1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                /*
                if(nameLength.length() <= 0){
                    Toast.makeText(getApplicationContext(),"닉네임을 입력하세요", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    //intent.putExtra("Name",name.getText().toString());
                    startActivity(intent);
                }*/
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent. setDataAndType(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        "image/*");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK
                && data != null && data.getData() != null) {
            Uri selectedImageUri = data.getData();
            profileImage.setImageURI(selectedImageUri);
        }
    }
}
