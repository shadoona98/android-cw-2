package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Screen2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        Bundle b = getIntent().getExtras();
        String n = b.getString("userName");
        String ph = b.getString("p1");
        String em = b.getString("e1");
        String ad = b.getString("ad1");

        TextView t = findViewById(R.id.hello);
        TextView p = findViewById(R.id.phone);
        TextView e = findViewById(R.id.email);
        TextView a = findViewById(R.id.address);

        t.setText("Hello "+n+"!");
        p.setText("phone number: "+ph);
        e.setText("email: "+em);
        a.setText("address: "+ad);

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callintent = new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:"+ph));
                startActivity(callintent);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, em);
                email.setType("text/plain");
                startActivity(Intent.createChooser(email, "Send email"));
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382, 10.013988");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });


    }
}