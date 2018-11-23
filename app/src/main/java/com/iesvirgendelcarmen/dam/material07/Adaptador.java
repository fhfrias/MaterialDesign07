package com.iesvirgendelcarmen.dam.material07;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.iesvirgendelcarmen.dam.material07.fragmentos.Primero;
import com.iesvirgendelcarmen.dam.material07.fragmentos.Segundo;
import com.iesvirgendelcarmen.dam.material07.fragmentos.Tercero;

public class Adaptador extends FragmentStatePagerAdapter {
    int numTab;

    public Adaptador(FragmentManager fm, int numTab) {
        super(fm);
        this.numTab = numTab;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i){
            case 0: Primero primero = new Primero();
                    return primero;

            case 1: Segundo segundo = new Segundo();
                    return segundo;

            case 2: Tercero tercero = new Tercero();
                    return tercero;

            default: return null;
        }
    }

    @Override
    public int getCount() {
        return numTab;
    }
}
