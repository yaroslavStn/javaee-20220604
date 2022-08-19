package dao;

import entity.City;
import org.junit.Test;

import static org.junit.Assert.*;

public class CityH2DaoTest {
    private final CityDao dao = new CityH2Dao();
    City testCity = new City("testCity");

    @Test
    public void saveCityTest() {
        dao.saveCity(testCity);
        assertEquals(1, dao.takeAllCities().size());
    }

    @Test
    public void readCityTest() {
        dao.saveCity(testCity);
        assertNotEquals(0, dao.findByName("testCity").size());
    }

    @Test
    public void deleteCityTest() {
        dao.saveCity(testCity);
        dao.deleteCity(testCity);
        assertNull(dao.findById(testCity.getId()));
    }

}
