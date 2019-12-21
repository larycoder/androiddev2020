package vn.edu.usth.weather;


import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import vn.edu.usth.weather.Data.forcastData;


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

    public void updateBackground(Bitmap bitmap){
        ImageView image = getView().findViewById(R.id.InternetImage);
        image.setImageBitmap(bitmap);
    }

    public void updateData(String string) {
        LinearLayout ll = getView().findViewById(R.id.TableOfWeather);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String[] DayInWeek = {"None", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        Date date;

        HashMap<String, Integer> WeatherIcon = new HashMap<>();
        WeatherIcon.put("Rain", R.drawable.rain);
        WeatherIcon.put("Clouds", R.drawable.cloudy);

        Gson gson = new Gson();
        forcastData data = gson.fromJson(string, forcastData.class);

        RelativeLayout mainWeather = getView().findViewById(R.id.WeatherLayout);
        TextView mainTextWeather = mainWeather.findViewById(R.id.Main_status_weather);
        Float value = (data.getTempMax(0) + data.getTempMin(0)) / 2;
        int intValue = getCelsiusFromKelvin(value);
        mainTextWeather.setText(data.getWeatherStatus(0) + "\n" + intValue + "C");
        TextView mainCity = mainWeather.findViewById(R.id.Main_city);
        mainCity.setText(data.getCity());
        ImageView mainImage = mainWeather.findViewById(R.id.WeatherFragment);
        mainImage.setImageResource(WeatherIcon.get(data.getWeatherStatus(0)));


        String stringDate = data.getDate(0);
        int countChild = 0, newDate = 0;
        float tempMin = data.getTempMin(0), tempMax = data.getTempMax(0);

        for(int i=0; i<data.totalList(); i++) {
            if(!data.getDate(i).substring(0, 10).equals(stringDate)) {
                newDate = 1;
                stringDate = data.getDate(i).substring(0, 10);
            }

            if(i == (data.totalList() - 1)) {
                if(data.getTempMin(i) < tempMin) tempMin = data.getTempMin(i);
                if(data.getTempMax(i) > tempMax) tempMax = data.getTempMax(i);
            }

            if(newDate == 1) {
                LinearLayout line = (LinearLayout) ll.getChildAt(countChild++);

                TextView text = (TextView) line.getChildAt(0);
                try {
                    date = df.parse(stringDate);
                    cal.setTime(date);
                } catch (ParseException e) {
                    Log.e("Calendar Parse error", e.toString());
                }
                text.setText(DayInWeek[cal.get(Calendar.DAY_OF_WEEK)]);

                ImageView image = (ImageView) line.getChildAt(1);
                image.setImageResource(WeatherIcon.get(data.getWeatherStatus(i)));

                LinearLayout lineStatus = (LinearLayout) line.getChildAt(2);
                TextView WeatherStatus = (TextView) lineStatus.getChildAt(0);
                WeatherStatus.setText(data.getWeatherStatus(i));
                TextView Temp = (TextView) lineStatus.getChildAt(1);
                int intTempMin = getCelsiusFromKelvin(tempMin);
                int intTempMax = getCelsiusFromKelvin(tempMax);
                Temp.setText(intTempMin + "C - " + intTempMax + "C");
            }

            if(data.getTempMin(i) < tempMin || newDate == 1) tempMin = data.getTempMin(i);
            if(data.getTempMax(i) > tempMax || newDate == 1) tempMax = data.getTempMax(i);

            newDate = 0;
        }
    }

    private int getCelsiusFromKelvin(float Ke){
        float Ca = (float) (Ke - 273.15);
        return Math.round(Ca);
    }
}
