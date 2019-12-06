package vn.edu.usth.weather;


import android.graphics.Bitmap;
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

import java.util.Random;

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
        View sv = inflater.inflate(R.layout.forecast_fragment, null, false);
        LinearLayout ll = sv.findViewById(R.id.TableOfWeather);

        // setup context of 10 forecast line
        for(int i = 0; i < 7; i++) {
            LinearLayout line = (LinearLayout) inflater.inflate(R.layout.forecast_line_status, null, false);
            // set name
            ((TextView) line.getChildAt(0)).setText(getResources().getStringArray(R.array.days)[i]);

            // set random for status
            int ran = new Random().nextInt(5);

            // set Image
            ((ImageView) line.getChildAt(1)).setImageResource(getResources().obtainTypedArray(R.array.weather_img).getResourceId(ran, -1));

            // set status
            ((TextView) ((LinearLayout) line.getChildAt(2)).getChildAt(0)).setText(getResources().getStringArray(R.array.weather_status)[ran]);
            ((TextView) ((LinearLayout) line.getChildAt(2)).getChildAt(1)).setText(getResources().getString(R.string.temp));

            // add forecast line to forecast table
            ll.addView(line);
        }
        return sv;
    }
}
