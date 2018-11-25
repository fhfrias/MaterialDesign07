package com.iesvirgendelcarmen.dam.material07;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.iesvirgendelcarmen.dam.material07.fragmentos.Primero;
import com.iesvirgendelcarmen.dam.material07.fragmentos.Segundo;
import com.iesvirgendelcarmen.dam.material07.fragmentos.Tercero;

public class Material07 extends AppCompatActivity {

    ViewPager paginador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material07);


        final TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("PRIMERO").setIcon(android.R.drawable.sym_def_app_icon));
        tabLayout.addTab(tabLayout.newTab().setText("SEGUNDO").setIcon(android.R.drawable.sym_def_app_icon));
        tabLayout.addTab(tabLayout.newTab().setText("TERCERO").setIcon(android.R.drawable.sym_def_app_icon));

        paginador = (ViewPager) findViewById(R.id.contenedor2);
        Adaptador adaptador = new Adaptador(getSupportFragmentManager(), tabLayout.getTabCount());
        paginador.setAdapter(adaptador);
        paginador.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //Escuchador
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Fragment fragmento = null;
                switch (tab.getPosition()){
                    case 0: fragmento = new Primero();
                            break;
                    case 1: fragmento = new Segundo();
                            break;
                    case 2: fragmento = new Tercero();
                            break;
                }

                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.contenedor, fragmento);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                ft.commit();

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}
