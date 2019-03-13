package com.timmyyeol.shipnamesslash;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class LevelsActivity extends AppCompatActivity {

    String[] img = new String[40];
    DatabaseHelper sqlHelper;
    SQLiteDatabase db;
    Cursor userCursor;
    DatabaseHelper databaseHelper;
    long userId=1;
    String our_level = "";
    int heart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_levels);

        GridView countriesList = (GridView) findViewById(R.id.gridview);

        sqlHelper = new DatabaseHelper(this);
        db = sqlHelper.getWritableDatabase();

        userCursor = db.rawQuery("select * from " + DatabaseHelper.TABLE + " where " +
                DatabaseHelper.COLUMN_ID + "=?", new String[]{String.valueOf(userId)});
        userCursor.moveToFirst();
        our_level = userCursor.getString(2);
        userCursor.close();

        int lev = Integer.valueOf(our_level);

        for (int i = 0; i < lev; i++) {
            img[i] = Integer.toString(i+1);
        }
        for (int i = lev; i < 40; i++) {
            img[i] = "X";
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.grid_item, R.id.tvText, img);
        countriesList.setAdapter(adapter);

        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                if(!parent.getItemAtPosition(position).toString().equals("X")) {

                    Intent i = new Intent(getApplicationContext(), GameActivity.class);
                    i.putExtra("lvl", parent.getItemAtPosition(position).toString());
                    startActivity(i);
                }
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    @Override
    public void onBackPressed() {
        db.close();
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }
}
