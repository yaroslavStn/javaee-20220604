package dao;

import entity.City;

import java.util.List;


public interface CityDao {

    List<City> takeAllCities();

    void saveCity(City city);

    City findById(int id);

    List<City> findByName (String request);


    void deleteCity(City city);
}
