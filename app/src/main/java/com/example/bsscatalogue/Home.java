package com.example.bsscatalogue;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Home extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    Profile profile = new Profile();
    Settings settings = new Settings();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set default fragment to display when activity is created
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_Layout, homeFragment).commit();

        // Set up listener for bottom navigation item selection
        bottomNavigationView.setOnItemSelectedListener(this::onNavigationItemSelected);
    }

    @SuppressLint("NonConstantResourceId")
    private boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment selectedFragment = null;

        // Use if-else statements for item selection
        int itemId = item.getItemId();
        if (itemId == R.id.homeIcon) {
            selectedFragment = homeFragment;
        } else if (itemId == R.id.settingsIcon) {
            selectedFragment = settings;
        } else if (itemId == R.id.profile) {
            selectedFragment = profile;
        }

        // Replace fragment if one is selected
        if (selectedFragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame_Layout, selectedFragment).commit();
            return true;
        }

        return false;
    }
}
