package com.lucas.actividad_4_fragments;

import android.content.Intent;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lucas.actividad_4_fragments.adapter.PageAdapter;
import com.lucas.actividad_4_fragments.fragment.PerfilFragment;
import com.lucas.actividad_4_fragments.fragment.ReciclerViewFragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // soporte actionbar

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);

        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.viewPager);

        setUpViewPager();

        if(miActionBar!=null)
        {
            setSupportActionBar(miActionBar);
        }
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new ReciclerViewFragment());
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dogs);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_footprint);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    // seleccion de elemento de menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
//            case R.id.mAbout:
////                break;
////
            case R.id.mContacto:
                Intent intentContacto = new Intent(this, com.lucas.actividad_4_fragments.Contacto.class);
                startActivity(intentContacto);
                break;

            case R.id.mAcercaDe:
                Intent intentAcerca = new Intent(this, com.lucas.actividad_4_fragments.AcercaDe.class);
                startActivity(intentAcerca);
                break;

            case R.id.mFavorites:
                Intent intentFav = new Intent(this, com.lucas.actividad_4_fragments.Favorites.class);
                startActivity(intentFav);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}