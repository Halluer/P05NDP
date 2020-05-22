package com.example.p05ndp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    ListView lv;
    TextView tvYear, tvTitle, tvSinger;
    ArrayAdapter aa;
    ArrayList<Song> song;
    ArrayList<Song> al;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        al = new ArrayList<Song>();

        lv = (ListView)findViewById(R.id.lv);
        tvYear = (TextView)findViewById(R.id.tvYear);
        tvTitle = (TextView)findViewById(R.id.tvTitle);
        tvSinger = (TextView)findViewById(R.id.tvSinger);
        DBHelper db = new DBHelper(SecondActivity.this);
        song =db.getAllNotes();

        aa = new RevisionNotesArrayAdapter(this, R.layout.row, song);
        lv.setAdapter(aa);


        lv = findViewById(R.id.lv);
        aa = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, al);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int
                    position, long identity) {
                Song data = al.get(position);
                Intent i = new Intent(SecondActivity.this,
                        EditActivity.class);
                i.putExtra("data", target);
                startActivityForResult(i, 9);
            }
        });


    }
}
