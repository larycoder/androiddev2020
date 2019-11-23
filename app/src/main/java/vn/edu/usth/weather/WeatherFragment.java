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

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);

        // set random weather status
        int ran = new Random().nextInt(5);

        // set status to weather table
        ((ImageView) view.findViewById(R.id.WeatherFragment)).setImageResource(getResources().obtainTypedArray(R.array.weather_img).getResourceId(ran, -1));
        ((TextView) view.findViewById(R.id.Main_status_weather)).setText("120C\n" + getResources().getStringArray(R.array.weather_status)[ran]);
        ((TextView) view.findViewById(R.id.Main_city)).setText("Paris");
        return view;
    }

}
