package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText n = findViewById(R.id.name);
        EditText p = findViewById(R.id.phone);
        EditText e = findViewById(R.id.email);
        EditText ad = findViewById(R.id.address);

        Button b = findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Screen2.class);
                String name = n.getText().toString();
                String phone = p.getText().toString();
                String email = e.getText().toString();
                String address = ad.getText().toString();

                i.putExtra("userName", name);
                i.putExtra("p1", phone);
                i.putExtra("e1", email);
                i.putExtra("ad1", address);

                startActivity(i);
            }
        });
    }
}