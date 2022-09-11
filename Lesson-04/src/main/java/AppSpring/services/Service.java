package AppSpring.services;

import AppSpring.entity.City;
import AppSpring.entity.Country;
import AppSpring.entity.Region;
import AppSpring.menu.KeyWord;
import AppSpring.repo.CityRepo;
import AppSpring.repo.CountryRepo;
import AppSpring.repo.RegionRepo;
import AppSpring.ui.SpringUi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Service {
    @Autowired
    private CityRepo cityRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private SpringUi ui;

    public void setUi(SpringUi ui) {
        this.ui = ui;
    }

    public void addCity() {
        ui.outputMessage("City is empty, enter city`s name");
        String name = ui.inputData();
        City city = cityRepo.findCityByName(name);
        if (city == null) {
            city = new City(name);
            ui.outputMessage("Region is empty, enter region`s name");
            name = ui.inputData();
            city.setRegion(regionIsEmpty(name));
            cityRepo.save(city);
            ui.outputMessage("City is saved");
        } else {
            ui.outputMessage("City was added earlier ");
        }

    }


    //  @Transactional
    public void addRegion() {
        ui.outputMessage("Region is empty, enter region`s name");
        String name = ui.inputData();
        regionIsEmpty(name);
        ui.outputMessage("Region is saved");
    }

    public void addCountry() {
        ui.outputMessage("Country is empty, enter country`s name");
        String name = ui.inputData();
        countryIsEmpty(name);
        ui.outputMessage("Country is saved");

    }


    public void findByName(KeyWord keyWord) {
        ui.outputMessage("Enter name for search:");
        String name = ui.inputData();
        String notFound = "not found";
        switch (keyWord) {
            case CITY -> {
                City city = cityRepo.findCityByName(name);
                if (city == null) ui.outputMessage(notFound);
                else ui.outputMessage(city.toString());
            }
            case REGION -> {
                Region region = regionRepo.findRegionByName(name);
                if (region == null) ui.outputMessage(notFound);
                else ui.outputMessage(region.toString());
            }
            case COUNTRY -> {
                Country country = countryRepo.findCountryByName(name);
                if (country == null) ui.outputMessage(notFound);
                else ui.outputMessage(country.toString());
            }
        }

    }


    public void findById(KeyWord keyWord) {
        ui.outputMessage("Enter ID for search:");
        Integer id = inputInt();
        String notFound = "not found";
        switch (keyWord) {
            case CITY -> {
                City city = cityRepo.findCityById(id);
                if (city == null) ui.outputMessage(notFound);
                else ui.outputMessage(city.toString());
            }
            case REGION -> {
                Region region = regionRepo.findRegionById(id);
                if (region == null) ui.outputMessage(notFound);
                else ui.outputMessage(region.toString());
            }
            case COUNTRY -> {
                Country country = countryRepo.findCountryById(id);
                if (country == null) ui.outputMessage(notFound);
                else ui.outputMessage(country.toString());
            }
        }

    }

    public void exit() {
        ui.outputMessage("Bye");

    }


    private Integer inputInt() {
        return ui.readInt();
    }

    private Region regionIsEmpty(String s) {

        Region region = regionRepo.findRegionByName(s);
        if (region == null) {
            region = new Region(s);
            ui.outputMessage("Country is empty, enter country`s name");
            s = ui.inputData();
            region.setCountry(countryIsEmpty(s));
            regionRepo.save(region);
        }
        return region;

    }

    private Country countryIsEmpty(String s) {
        Country country = countryRepo.findCountryByName(s);
        if (country == null) {
            country = new Country(s);
            countryRepo.save(country);
            ui.outputMessage("Country is saved");
        }
        return country;
    }

}
