package controller;

import dao.CityDao;
import dao.CityH2Dao;
import entity.City;

import ui.CityUI;

import java.util.List;

public class Controller {
    private final CityDao dao = new CityH2Dao();
    private final CityUI ui;

    public Controller(CityUI ui) {
        this.ui = ui;
    }

    public void printCities() {
        dao.takeAllCities().forEach(city -> ui.print(city));
    }

    public void addCity() {
        //TO DO unique db or delete everyone matches
        ui.printMessage("Write a city");
        dao.saveCity(ui.readCity());
    }

    public void findCityById() {
        try {
            ui.print(dao.findById(ui.intRequest()));
        }
        catch (NullPointerException e){
            ui.printMessage("ID is not found");
        }

    }

    public void findCityByName() {
        ui.printMessage("Write a city");
        List<City> cities = dao.findByName(ui.stringRequest());
        if (cities.size() == 0) {
            ui.printMessage("No matches");
        } else {
            ui.printMessage("City is found");
            cities.forEach(city -> ui.print(city));
        }
    }

    public void exit() {
        ui.printMessage("Bye!");
    }

    public void deleteCity() {
        ui.printMessage("Write city for delete");
        try {
            List<City> cities = dao.findByName(ui.stringRequest());
            cities.forEach(city -> dao.deleteCity(city));
        }
        catch (Exception e){
            ui.printMessage("Data is not found");
        }
    }


}

