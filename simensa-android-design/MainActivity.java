package com.example.sistemadministrasipersuratanv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav_action);
        bottomNavigationView.setOnNavigationItemSelectedListener( navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new MailFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemReselectedListener navListener =
            new BottomNavigationView.OnNavigationItemReselectedListener() {
                @Override
                public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_account:
                            selectedFragment = new AccountFragment();
                            break;
                        case R.id.nav_mail:
                            selectedFragment = new MailFragment();
                            break;
                        case R.id.nav_search:
                            selectedFragment = new SearchFragment();
                            break;
                        case R.id.nav_contacts:
                            selectedFragment = new ContactFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
