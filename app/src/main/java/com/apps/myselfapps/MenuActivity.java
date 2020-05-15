package com.apps.myselfapps;

/*
    Developed by 10117192 - Prana Reza Alviana - IF5
    9 May 2020
 */


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.ListFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MenuActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);


        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.home);
    }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                        new HomeFragment()).commit();
                break;
            case R.id.daily:
                getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                        new DailyActivityFragment()).commit();
                break;
            case R.id.gallery:
                getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                        new GalleryFragment()).commit();
                break;
            case R.id.music:
                getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                        new MusvidFragment()).commit();
                break;
            case R.id.profile:
                getSupportFragmentManager().beginTransaction().replace(R.id.flayout,
                        new ProfileFragment()).commit();
                break;
            case R.id.logout:
                startActivity(new Intent(MenuActivity.this, MainActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
                Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
                break;

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
