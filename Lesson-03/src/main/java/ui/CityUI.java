package ui;

import entity.City;

public interface CityUI {
    City readCity();

    void print(City city);

    String stringRequest();
    int intRequest();


    void printMessage(String s);

}
