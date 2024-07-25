package edu.divyagyan.menuexample;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView contextTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contextTextView = findViewById(R.id.helloTextView);
        registerForContextMenu(contextTextView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.searchMenu){
            Toast.makeText(this,"Search Menu clicked",Toast.LENGTH_SHORT).show();
        }
        if (item.getItemId() == R.id.aboutMenu){
            Toast.makeText(this,"About Menu clicked",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        MenuInflater menuInflater =  getMenuInflater();
        menuInflater.inflate(R.menu.context_menu, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.copyMenuItem){
            Toast.makeText(this, "Copy menu item selected", Toast.LENGTH_LONG).show();
        }

        if(item.getItemId() == R.id.selectMenuItem){
            Toast.makeText(this, "Select menu item selected", Toast.LENGTH_LONG).show();
        }


        if(item.getItemId() == R.id.cutMenuItem){
            Toast.makeText(this, "Cut menu item selected", Toast.LENGTH_LONG).show();
        }
        return true;
    }
}
