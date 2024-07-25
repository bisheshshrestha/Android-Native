package edu.divyagyan.listviewexamples;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SimpleListViewActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    //data source
    private String[] datas = {"Ram","Shyam","Hari","Bishesh","Sushmita","Kishan","Sita","Gita"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_listview);
        listView = findViewById(R.id.simpleListView);
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,datas);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(SimpleListViewActivity.this, "Clicked "+datas[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
}
