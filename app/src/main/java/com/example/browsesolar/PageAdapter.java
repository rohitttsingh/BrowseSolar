package com.example.browsesolar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import org.jetbrains.annotations.NotNull;

public class PageAdapter extends FragmentPagerAdapter {

    int tabcount;
    public PageAdapter(@NonNull @NotNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabcount=behavior;
    }

    @NonNull
    @NotNull
    @Override
    public Fragment getItem(int position)
    {
        switch (position)
        {
            case 0 : return  new ftab1();
            case 1 : return  new ftab2();
            case 2 : return  new ftab3();
            case 3 : return  new ftab4();
            default: return null;

        }

    }

    @Override
    public int getCount() {
        return tabcount;
    }
}
