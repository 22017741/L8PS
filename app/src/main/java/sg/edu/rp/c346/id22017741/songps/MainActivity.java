package sg.edu.rp.c346.id22017741.songps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button insert, view;
    EditText sTitle, singers, year;
    RadioGroup rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        insert = findViewById(R.id.btnInsert);
        view = findViewById(R.id.btnView);
        sTitle = findViewById(R.id.etTitle);
        singers = findViewById(R.id.etSinger);
        year = findViewById(R.id.etYear);
        rating = findViewById(R.id.rgStars);

        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                int ratingID = rating.getCheckedRadioButtonId();
                String star = "";
                if(ratingID == R.id.rb1){
                    star = "1";
                }else if(ratingID == R.id.rb2){
                    star = "2";
                }else if(ratingID == R.id.rb3){
                    star = "3";
                }else if(ratingID == R.id.rb4){
                    star = "4";
                }else{
                    star = "5";
                }
                db.insertSong(sTitle.getText().toString(), singers.getText().toString(), Integer.parseInt(year.getText().toString()), star);
                db.close();
            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, list.class);
                startActivity(intent);
            }
        });

    }
}