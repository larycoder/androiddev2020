package vn.edu.usth.weather;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class WeatherFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int PAGE_COUNT = 3;
    private Context context;

    private String titles[] = new String[] {"hanoi", "paris", "toulouse"};

    public WeatherFragmentPagerAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int page) {
        if (page < PAGE_COUNT && page > -1)
            return WeatherAndForeCasttFragment.newInstance(page);
        return new Fragment();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int page) {
        return getContext().getResources().getStringArray(R.array.city)[page];
    }

    public void setResource(Context R){
        this.context = R;
    }

    private Context getContext(){
        return context;
    }
}

