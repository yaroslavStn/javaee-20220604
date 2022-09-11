package AppSpring.repo;

import AppSpring.entity.Region;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends CrudRepository<Region, Integer> {
    Region findRegionByName(String s);
    Region findRegionById (Integer i);

}
