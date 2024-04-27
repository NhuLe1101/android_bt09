package com.example.modern_art_ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class MyPagerAdapter extends FragmentStateAdapter {
    private static final int NUM_PAGES = 3;

    public MyPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new linear_layout();
            case 1:
                return new relative_layout();
            case 2:
                return new table_layout();
            default:
                return new linear_layout();
        }
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}