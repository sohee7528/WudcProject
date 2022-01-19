package com.android.wudc;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileActivity extends AppCompatActivity {

    public TextView name=findViewById(R.id.name);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ImageButton rename= findViewById(R.id.rename);

        //login에서 이름 받아오기
        Intent inIntent = getIntent();
        String Name = inIntent.getStringExtra("Name");
        name.setText(Name);

        rename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //profile2로 이름 보내기
                Intent intent = new Intent(ProfileActivity.this, Profile2Activity.class);
                intent.putExtra("Name",name.getText().toString());
                startActivityForResult(intent,0);
            }
        });
        /*
        CircleImageView profileImage = findViewById(R.id.profileImage);
        ImageButton tab2 = findViewById(R.id.tab2);



        //Uri selectedImageUri = Uri.parse(bundle.getString("uri"));
        //profileImage.setImageURI(selectedImageUri);

        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);

        profileImage.setImageBitmap(bitmap);
 */



        /*tab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            String Name = data.getStringExtra("Name");
            name.setText(Name);
        }
    }
}