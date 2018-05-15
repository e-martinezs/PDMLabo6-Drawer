package com.example.pdmlabo6;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private int selectedFragment = 0;
    public static List<com.example.pdmlabo6.MenuItem> list = new ArrayList<>();
    private static List<com.example.pdmlabo6.MenuItem> list1 = new ArrayList<>();
    private static List<com.example.pdmlabo6.MenuItem> list2 = new ArrayList<>();
    private static List<com.example.pdmlabo6.MenuItem> list3 = new ArrayList<>();
    private static List<com.example.pdmlabo6.MenuItem> list4 = new ArrayList<>();
    private static List<com.example.pdmlabo6.MenuItem> list5 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            selectedFragment = savedInstanceState.getInt("FRAGMENT");
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        drawerLayout = findViewById(R.id.drawerLayout);
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                setListFragment(item.getOrder());
                selectedFragment = item.getOrder();
                drawerLayout.closeDrawers();
                return true;
            }
        });

        fillList();
        setListFragment(selectedFragment);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setListFragment(int id){
        switch (id){
            case 0:
                list = list1;
                break;
            case 1:
                list = list2;
                break;
            case 2:
                list = list3;
                break;
            case 3:
                list = list4;
                break;
            case 4:
                list = list5;
                break;
        }
        MenuListFragment fragment = new MenuListFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.contentLayout, fragment);
        transaction.commit();
    }

    private void fillList(){
        list = new ArrayList<>();

        list1 = new ArrayList<>();
        list1.add(new com.example.pdmlabo6.MenuItem("list1 name1","description1"));
        list1.add(new com.example.pdmlabo6.MenuItem("list1 name2","description2"));

        list2 = new ArrayList<>();
        list2.add(new com.example.pdmlabo6.MenuItem("list2 name1","description1"));
        list2.add(new com.example.pdmlabo6.MenuItem("list2 name2","description2"));
        list2.add(new com.example.pdmlabo6.MenuItem("list2 name3","description3"));

        list3 = new ArrayList<>();
        list3.add(new com.example.pdmlabo6.MenuItem("list3 name1","description1"));
        list3.add(new com.example.pdmlabo6.MenuItem("list3 name2","description2"));
        list3.add(new com.example.pdmlabo6.MenuItem("list3 name3","description3"));
        list3.add(new com.example.pdmlabo6.MenuItem("list3 name4","description4"));

        list4 = new ArrayList<>();
        list4.add(new com.example.pdmlabo6.MenuItem("list4 name1","description1"));

        list5 = new ArrayList<>();
        list5.add(new com.example.pdmlabo6.MenuItem("list5 name1","description1"));
        list5.add(new com.example.pdmlabo6.MenuItem("list5 name2","description2"));
        list5.add(new com.example.pdmlabo6.MenuItem("list5 name3","description3"));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("FRAGMENT", selectedFragment);
        super.onSaveInstanceState(savedInstanceState);
    }
}
