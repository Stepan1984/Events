package com.banana.events;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
// устанавливаем для неё картинку
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // отображаем ДОМОЙ
        getSupportActionBar().setHomeButtonEnabled(true); // включаем ДОМОЙ
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout); // находим дровер
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, 0, 0); // создаём штуку, которая будет анимировать иконку (и не только)
        mDrawerLayout.addDrawerListener(mDrawerToggle); // подписываем её на события открытия и закрытия дровера (чтобы она знала, когда нужно анимировать кнопку)

        Context context = MainActivity.this;

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        EventAdapter adapter = new EventAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

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
