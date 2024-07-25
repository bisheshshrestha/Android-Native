package edu.divyagyan.loginsignupexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity{

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button loginButton;

    private TextView signupTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //find view by id
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton= findViewById(R.id.loginButton);

        //1.anonymous class
        //event registration
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = userNameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if(!userName.isEmpty()){
                    if(!password.isEmpty()){
                        Toast.makeText(LoginActivity.this,"Login Success",Toast.LENGTH_LONG).show();
                    }
                    else{
                        passwordEditText.setError("Invalid Password");
                    }

                }else{
                    userNameEditText.setError("Invalid Username");
                }
            }
        });

    }
}
