package edu.divyagyan.gettingdatafromsecondactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private EditText userNameEditText;
    private Button clickMeButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        userNameEditText =findViewById(R.id.userName);
        clickMeButton = findViewById(R.id.clickMeButton);

        clickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString().trim();

                if (userName.length()<15 && !userName.isEmpty()){
                    Intent intent = new Intent();
                    intent.putExtra("username",userName);
                    setResult(201,intent);
                    finish();
                }else{
                    Toast.makeText(SecondActivity.this,"Invalid username",Toast.LENGTH_LONG).show();
                }

            }
        });


    }
}
