package edu.divyagyan.dialogfragmentexample;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button logoutButton,customDialogButton,calculateButton;
    private EditText firstNumberEditText,secondNumberEditText;
    private TextView resultEditText;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logoutButton = findViewById(R.id.logoutButton);
        customDialogButton =findViewById(R.id.customDialogButton);

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialogFragmentExample dialogFragmentExample = new AlertDialogFragmentExample();
                dialogFragmentExample.show(getSupportFragmentManager(),"Alert");
            }
        });

        customDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initDialogAlert();

            }
        });

    }

    private void initDialogAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        View view = getLayoutInflater().inflate(R.layout.dialog_custom,null);
        builder.setView(view);
        initComponents(view);
        onclickDialogSum();
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }
    private  void initComponents(View view){
        firstNumberEditText = view.findViewById(R.id.firstNumberInputEditText);
        secondNumberEditText = view.findViewById(R.id.secondNumberInputEditText);
        calculateButton = view.findViewById(R.id.calculateButton);
        resultEditText = view.findViewById(R.id.resultTextView);

    }
    private void onclickDialogSum(){
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int firstNumber = Integer.parseInt(firstNumberEditText.getText().toString().trim());
                int secondNumber = Integer.parseInt(secondNumberEditText.getText().toString().trim());
                int sum =firstNumber + secondNumber;
                resultEditText.setText("The result is :" + sum);
            }
        });
    }
}
