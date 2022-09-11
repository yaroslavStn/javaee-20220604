package AppSpring.repo;

import AppSpring.entity.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepo extends CrudRepository<Country, Integer> {
    Country findCountryByName(String s);
    Country findCountryById (Integer n);
}
