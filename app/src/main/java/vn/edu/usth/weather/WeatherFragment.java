package vn.edu.usth.weather;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class WeatherFragment extends Fragment {
    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // set string of weather image
        int[] img = {R.drawable.cloudy, R.drawable.rain, R.drawable.rainy, R.drawable.heavy_rain, R.drawable.sunny};

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ((ImageView) view.findViewById(R.id.WeatherFragment)).setImageResource(img[new Random().nextInt(5)]);
        ((TextView) view.findViewById(R.id.Main_status_weather)).setText("120C\nSunny");
        ((TextView) view.findViewById(R.id.Main_city)).setText("Paris");
        return view;
    }

}
