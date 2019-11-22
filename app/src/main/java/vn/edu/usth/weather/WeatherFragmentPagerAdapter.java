package vn.edu.usth.weather;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGE_COUNT = 3;
    private String titles[] = new String[] {"Hanoi", "Paris", "Toulouse"};

    public WeatherFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int page) {
        switch (page){
            case 0: return new WeatherAndForeCasttFragment();
            case 1: return new WeatherAndForeCasttFragment();
            case 2: return new WeatherAndForeCasttFragment();
        }
        return new WeatherAndForeCasttFragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

