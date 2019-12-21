package vn.edu.usth.weather.Data;

import java.util.ArrayList;
import java.util.List;

public class forcastData {
    public List<listCollection> list = new ArrayList<>();
    public City city = new City();
    public int totalList(){
        return list.size();
    }
    public String getDate(int index){
        return this.list.get(index).dt_txt;
    }
    public String getWeatherStatus(int index){
        return this.list.get(index).weather.get(0).main;
    }
    public float getTempMin(int index){ return this.list.get(index).main.temp_min; }
    public float getTempMax(int index){ return this.list.get(index).main.temp_max; }
    public String getCity(){ return city.name; }
}

class listCollection{
    public Main main = new Main();
    public List<weatherCollection> weather = new ArrayList<>();
    public String dt_txt;
}

class weatherCollection{
    public String main;
}

class Main{
    public float temp_min;
    public float temp_max;
}

class City{
    public String name;
}