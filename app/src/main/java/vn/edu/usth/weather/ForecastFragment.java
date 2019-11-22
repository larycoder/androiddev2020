package vn.edu.usth.weather;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ForecastFragment extends Fragment {


    public ForecastFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // get current view
        ScrollView sv = (ScrollView) inflater.inflate(R.layout.forecast_fragment, null, false);
        LinearLayout ll = (LinearLayout) sv.getChildAt(0);

        // set enum of days
        String[] days = {"Mon", "Tue", "Wed", "Thus", "Fri", "Sat", "Sun"};

        // set enum of weather
        int[] weather_type = {R.drawable.cloudy, R.drawable.heavy_rain, R.drawable.rain, R.drawable.rainy, R.drawable.sunny};

        // set enum of status
        String[] status1 = {"Cloudy", "Heavy_rain", "Rain", "Rainy", "Sunny"};
        String status2 = "0C - 100C";

        // setup context of 10 forecast line
        for(int i = 0; i < 7; i++) {
            LinearLayout line = (LinearLayout) inflater.inflate(R.layout.forecast_line_status, null, false);
            // set name
            ((TextView) line.getChildAt(0)).setText(days[i % 7]);

            // set Image
            ((ImageView) line.getChildAt(1)).setImageResource(weather_type[i % 5]);

            // set status
            ((TextView) ((LinearLayout) line.getChildAt(2)).getChildAt(0)).setText(status1[i % 5]);
            ((TextView) ((LinearLayout) line.getChildAt(2)).getChildAt(1)).setText(status2);

            // add forecast line to forecast table
            ll.addView(line);
        }
        return sv;
    }
}
