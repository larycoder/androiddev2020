package vn.edu.usth.weather;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherFragment extends Fragment {
    public WeatherFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        ((ImageView) view.findViewById(R.id.WeatherFragment)).setImageResource(R.drawable.sunny);
        ((TextView) view.findViewById(R.id.Main_status_weather)).setText("120C\nSunny");
        ((TextView) view.findViewById(R.id.Main_city)).setText("Paris");
        return view;
    }

}
