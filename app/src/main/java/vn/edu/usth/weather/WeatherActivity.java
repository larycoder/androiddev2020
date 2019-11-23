package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

public class WeatherActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        Log.i("Create", "call Create");

        // create adapter
        WeatherFragmentPagerAdapter adapter = new WeatherFragmentPagerAdapter(getSupportFragmentManager());
        adapter.setResource(getApplicationContext());

        ViewPager pager = findViewById(R.id.pager);
        pager.setOffscreenPageLimit(2);
        pager.setAdapter(adapter);

        // create tab layout
        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(pager);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Start", "call Start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Destroy", "call Destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Stop", "call Stop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Resume", "call Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Pause", "call Pause");
    }
}
