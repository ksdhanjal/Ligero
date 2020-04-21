package com.kamaldeep.ligero.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.kamaldeep.ligero.R;
import com.kamaldeep.ligero.ui.main.ledFragments.LED1Fragment;
import com.kamaldeep.ligero.ui.main.ledFragments.LED2Fragment;
import com.kamaldeep.ligero.ui.main.ledFragments.LED3Fragment;
import com.kamaldeep.ligero.ui.main.ledFragments.LED4Fragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,
            R.string.tab_text_3, R.string.tab_text_4};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm)
    {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position)
    {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

        Fragment fragment = new HomeFragment();

        switch(position)
        {
            case 0: fragment = new LED1Fragment();
                break;
            case 1: fragment = new LED2Fragment();
                break;
            case 2: fragment = new LED3Fragment();
                break;
            case 3: fragment = new LED4Fragment();
                break;

        }

        return fragment;
//        return PlaceholderFragment.newInstance(position + 1);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 4;
    }
}