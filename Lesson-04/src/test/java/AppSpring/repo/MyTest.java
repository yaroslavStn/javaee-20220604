package AppSpring.repo;

import AppSpring.entity.City;
import AppSpring.entity.Country;
import AppSpring.entity.Region;
import AppSpring.services.Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

import java.util.logging.Logger;

@SpringBootTest
public class MyTest {
    private final Logger LOG = Logger.getLogger(MyTest.class.getName());
    @Autowired
    private CountryRepo countryRepo;
    @Autowired
    private RegionRepo regionRepo;
    @Autowired
    private CityRepo cityRepo;

    @MockBean
    private Service service;

    @MockBean
    ApplicationRunner applicationRunner;

    @MockBean
    CommandLineRunner commandLineRunner;


    @Test
    public void repoTest() {
        Country country = new Country("a");
        countryRepo.save(country);
        Region region = new Region("a");
        region.setCountry(country);
        regionRepo.save(region);
        City city = new City("a");
        city.setRegion(region);
        cityRepo.save(city);
        Assert.notNull(cityRepo.findCityByName("a"), "null");
        Assert.notNull(regionRepo.findRegionByName("a"), "null");
        Assert.notNull(countryRepo.findCountryByName("a"), "null");

    }


}
