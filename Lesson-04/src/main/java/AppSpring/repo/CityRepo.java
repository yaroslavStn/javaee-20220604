package AppSpring.repo;

import AppSpring.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository <City, Integer> {

    City findCityByName(String s);
    City findCityById (Integer n);

    }
