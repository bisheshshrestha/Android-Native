package edu.divyagyan.deliveryserviceapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    EditText usernamloginEditText, passwordloginEditText;
    Button loginButton;
    TextView signupRedirectTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernamloginEditText =findViewById(R.id.usernamloginEditText);
        passwordloginEditText = findViewById(R.id.passwordloginEditText);
        signupRedirectTextView =findViewById(R.id.signupRedirectTextView);
        loginButton =findViewById(R.id.loginButton);

        usernamloginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()<2){
                    usernamloginEditText.setError("invalid");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!validateUsername() | !validatePassword()){
                    Toast.makeText(LoginActivity.this, "Username or passsword does not match", Toast.LENGTH_SHORT).show();
                }else{
                    checkUser();
                }
            }
        });
        signupRedirectTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateUsername(){
        String val = usernamloginEditText.getText().toString();
        if (val.isEmpty()){
            usernamloginEditText.setError("Username cannot be empty");
            return false;
        }else{
            usernamloginEditText.setError(null);
            return  true;
        }
    }

    public Boolean validatePassword(){
        String val = passwordloginEditText.getText().toString();
        if (val.isEmpty()){
            usernamloginEditText.setError("Password cannot be empty");
            return false;
        }else{
            usernamloginEditText.setError(null);
            return  true;
        }
    }

    public void checkUser(){
        String userUsername = usernamloginEditText.getText().toString().trim();
        String userPassword = passwordloginEditText.getText().toString().trim();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
        Query checkUserDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUserDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    usernamloginEditText.setError(null);
                    String passwordFromDB = snapshot.child(userUsername).child("password").getValue(String.class);
                    if (passwordFromDB.equals(userPassword)) {
                        usernamloginEditText.setError(null);
                        String nameFromDB = snapshot.child(userUsername).child("name").getValue(String.class);
                        String emailFromDB = snapshot.child(userUsername).child("email").getValue(String.class);
                        String usernameFromDB = snapshot.child(userUsername).child("username").getValue(String.class);
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("name", nameFromDB);
                        intent.putExtra("email", emailFromDB);
                        intent.putExtra("username", usernameFromDB);
                        intent.putExtra("password", passwordFromDB);
                        startActivity(intent);
                    } else {
                        passwordloginEditText.setError("Invalid Credentials");
                        passwordloginEditText.requestFocus();
                    }
                } else {
                    usernamloginEditText.setError("User does not exist");
                    usernamloginEditText.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
