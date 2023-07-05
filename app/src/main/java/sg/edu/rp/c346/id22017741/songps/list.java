package sg.edu.rp.c346.id22017741.songps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    Button back;
    ListView lv;
    ArrayAdapter<String> aa;
    ArrayList<Song> arrList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        back = findViewById(R.id.btnBack);
        lv = findViewById(R.id.lv);

        DBHelper db = new DBHelper(list.this);
        db.close();
        DBHelper lvdb = new DBHelper(list.this);
        arrList = lvdb.getSongContent();
        lvdb.close();
        aa = new ArrayAdapter(list.this, android.R.layout.simple_list_item_1, arrList);
        lv.setAdapter(aa);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(list.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}