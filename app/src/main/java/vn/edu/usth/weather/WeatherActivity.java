package vn.edu.usth.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

import com.google.android.material.tabs.TabLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class WeatherActivity extends AppCompatActivity {
    // link to storage of file
    private String PathFile = "/sdcard/Download/nhacdubaothoitietvtc14.mp3";

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

        // add file to sdcard
        // addFileToSdcard();

        // play mp3
        MediaPlayer mp = MediaPlayer.create(WeatherActivity.this, Uri.parse(PathFile));
        mp.start();
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

    protected void addFileToSdcard(){
        // add music to android storage
        try {
            // get mp3 file
            InputStream is = getResources().openRawResource(R.raw.nhacdubaothoitietvtc14);
            // create file for music in android
            File file = new File(PathFile);
            if(!file.exists())
                file.createNewFile();
            // push data to buffer
            byte[] buffer = new byte[is.available()];
            is.read(buffer);

            // push data to android storage
            OutputStream os = new FileOutputStream(file);
            os.write(buffer);
            os.flush();

            // close file
            os.close();
            is.close();

        } catch(FileNotFoundException ex){
            Log.e("WeatherActivity", "File not found " + ex.toString());
        } catch(IOException ex){
            Log.e("WeatherActivity", ex.toString());
        }
    }
}
