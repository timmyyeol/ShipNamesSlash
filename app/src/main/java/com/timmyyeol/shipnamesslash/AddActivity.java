package com.timmyyeol.shipnamesslash;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    EditText txt1, txt2, txt3, txt4, txt5;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add);

        txt1 = findViewById(R.id.textView);
        txt1.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        txt2 = findViewById(R.id.textView2);
        txt2.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        txt3 = findViewById(R.id.textView3);
        txt3.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        txt4 = findViewById(R.id.textView4);
        txt4.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        txt5 = findViewById(R.id.textView5);
        txt5.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));
        btn = findViewById(R.id.button0);
        btn.setTypeface(Typeface.createFromAsset(
                getAssets(), "OzHandicraftWin.ttf"));

    }

    public void Sent(View view) {
        if(txt1.getText().toString().length()>0 && txt2.getText().toString().length()>0) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();

            DatabaseReference myRef = database.getReference("pairings/" + txt1.getText().toString());
            myRef.setValue(txt1.getText().toString());

            DatabaseReference myRef2 = database.getReference("pairings/" + txt1.getText().toString() + "/where");
            myRef2.setValue(txt2.getText().toString());

            DatabaseReference setDate = database.getReference("versions/" + txt1.getText().toString() + "/fem");
            setDate.setValue(txt3.getText().toString());

            DatabaseReference setAddress = database.getReference("versions/" + txt1.getText().toString() + "/getero");
            setAddress.setValue(txt4.getText().toString());

            DatabaseReference setPassword = database.getReference("wishes/" + txt1.getText().toString() + "/wishes");
            setPassword.setValue(txt5.getText().toString());

            Toast toast = Toast.makeText(getApplicationContext(), "THANK YOU", Toast.LENGTH_LONG);
            toast.show();

            Intent i = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(i);

        }
    }
}
