package com.banana.events;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle mDrawerToggle;
    DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database.load();

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, new EventsFragment(), null)
                    .commit();
        }

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
// устанавливаем для неё картинку
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // отображаем ДОМОЙ
        getSupportActionBar().setHomeButtonEnabled(true); // включаем ДОМОЙ
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // находим дровер
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
        mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия дровера (чтобы она знала, когда нужно анимировать кнопку)

        NavigationView navigationView = findViewById(R.id.navigation_view); // находим вьюху
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) { // если выбрали пункт
                   case R.id.item1 :  // выход
                       EventsFragment fragment = EventsFragment.newInstance();
                       MainActivity.this.getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
                       mDrawerLayout.closeDrawer(Gravity.LEFT);
                       return true; // возвращаем true, мол, обработали нажатие
                    case R.id.item2 :
                        finish();
                        return  true;
                    default: // иначе
                        return false; // возврващаем false, мол, этот пункт меню не поддерживаем
                }
            }
        });


    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // если нажали на
            case android.R.id.home: // кнопку меню
                // ищем меню
                DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
                if (drawerLayout.isDrawerOpen(Gravity.START)) { // если уже открыто
                    drawerLayout.closeDrawer(Gravity.START); // закрываем
                } else { // иначе
                    drawerLayout.openDrawer(Gravity.START); // открываем
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        mDrawerToggle.onConfigurationChanged(newConfig);
    }






}
