package AppSpring.services;

import AppSpring.menu.KeyWord;
import AppSpring.repo.CityRepo;
import AppSpring.repo.CountryRepo;
import AppSpring.repo.RegionRepo;
import AppSpring.ui.SpringUi;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;

@SpringBootTest
class ServiceTest {

    @Autowired
    Service service;
    @MockBean
    ApplicationRunner applicationRunner;
    @MockBean
    CommandLineRunner commandLineRunner;
    @MockBean
    private CityRepo cityRepo;
    @MockBean
    private RegionRepo regionRepo;
    @MockBean
    private CountryRepo countryRepo;
    @MockBean
    private SpringUi ui;

    @Test
    void addCity() {
        doReturn("a")
                .when(ui).
                inputData();
        service.addCity();
        verify(cityRepo, times(1)).findCityByName("a");
        verify(cityRepo, times(1)).save(any());

    }

    @Test
    void addRegion() {
        doReturn("a")
                .when(ui).
                inputData();
        service.addRegion();
        verify(regionRepo, times(1)).findRegionByName("a");
        verify(regionRepo, times(1)).save(any());
    }

    @Test
    void addCountry() {
        doReturn("a")
                .when(ui).
                inputData();
        service.addCountry();
        verify(countryRepo, times(1)).findCountryByName("a");
        verify(countryRepo, times(1)).save(any());
    }

    @Test
    void findByName() {
        doReturn("a")
                .when(ui).
                inputData();
        service.findByName(KeyWord.CITY);
        verify(cityRepo, times(1)).findCityByName("a");
        service.findByName(KeyWord.COUNTRY);
        verify(countryRepo, times(1)).findCountryByName("a");
        service.findByName(KeyWord.REGION);
        verify(regionRepo, times(1)).findRegionByName("a");

    }

    @Test
    void findById() {
        doReturn(1)
                .when(ui).readInt();
        service.findById(KeyWord.CITY);
        verify(cityRepo, times(1)).findCityById(1);
        service.findById(KeyWord.COUNTRY);
        verify(countryRepo, times(1)).findCountryById(1);
        service.findById(KeyWord.REGION);
        verify(regionRepo, times(1)).findRegionById(1);

    }
}