package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
}
