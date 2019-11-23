package vn.edu.usth.weather;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WeatherAndForeCasttFragment extends Fragment {


    public WeatherAndForeCasttFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // set city text view
        RelativeLayout Rl = view.findViewById(R.id.WeatherLayout);
        TextView city = Rl.findViewById(R.id.Main_city);
        city.setText(getResources().getStringArray(R.array.city)[getArguments().getInt("city")]);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather_and_fore_castt, container, false);
    }

    protected static WeatherAndForeCasttFragment newInstance(int city){
        // create object
        WeatherAndForeCasttFragment obj = new WeatherAndForeCasttFragment();

        // add city to each pager
        Bundle data = new Bundle();
        data.putInt("city", city);
        obj.setArguments(data);

        return obj;
    }

}
