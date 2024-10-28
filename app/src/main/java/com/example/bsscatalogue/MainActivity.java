package com.example.bsscatalogue;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class MainActivity extends AppCompatActivity {

    private final String username = "david@gmail.com";
    private final String password = "12345678";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.loginBtn);

        btn.setOnClickListener(view -> {

            EditText ed = findViewById(R.id.username);
            String user = String.valueOf(ed.getText());

            EditText pass = findViewById(R.id.password);
            String userPass = pass.getText().toString();


            if (!user.equals(username) || !userPass.equals(password)){
                ed.setBackgroundTintList(ContextCompat.getColorStateList(this,
                        android.R.color.holo_red_light));
                pass.setBackgroundTintList(ContextCompat.getColorStateList(this,
                        android.R.color.holo_red_light));
                Toast.makeText(this, "invalid username or password",
                        Toast.LENGTH_LONG).show();
            } else {

                Intent intent = new Intent(MainActivity.this, Home.class);
                startActivity(intent);
            }

        });
    }
}