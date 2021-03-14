package com.e3okoss.tesGuide;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.e3okoss.tesGuide.tools.Constants;
import com.e3okoss.tesGuide.tools.TinyDB;

public class SliderPagerAdapter extends FragmentPagerAdapter {
    Context context;
    public SliderPagerAdapter(Context context, @NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.context = context;
    }

    @NonNull @Override public Fragment getItem(int position) {
        return SliderItemFragment.newInstance(position);
    }
    // size is hardcoded
    @Override public int getCount() {
        TinyDB tinyDB = new TinyDB(context);
        return tinyDB.getInt(Constants.JSON_TOTAL_ITEMS);
    }
}