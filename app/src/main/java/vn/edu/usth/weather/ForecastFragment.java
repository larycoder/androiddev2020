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
        View view = inflater.inflate(R.layout.activity_weather, container, false);

        // get id of linear layout
        LinearLayout ll = view.findViewById(R.id.LinearLayout);

        // create text view
        TextView tv = new TextView(getActivity());
        tv.setText("Thursday");

        // create image view
        ImageView iv = new ImageView(getActivity());
        iv.setImageResource(R.drawable.weather_icon);

        // add text view and image view to linear layout
        ll.addView(tv);
        ll.addView(iv);

        return view;
    }
}
