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
        LinearLayout ll = (LinearLayout) inflater.inflate(R.layout.forecast_fragment, null, false);

        // setup context of 10 forecast line
        for(int i = 0; i < 10; i++) {
            LinearLayout line = (LinearLayout) inflater.inflate(R.layout.forecast_line_status, null, false);
            // set name
            ((TextView) line.getChildAt(0)).setText("Thursday");
            // set Image
            ((ImageView) line.getChildAt(1)).setImageResource(R.drawable.weather_icon);
            // set status
            ((TextView) line.getChildAt(2)).setText("Partly Cloudy");
            // add forecast line to forecast table
            ll.addView(line);
        }
        return ll;
    }
}
