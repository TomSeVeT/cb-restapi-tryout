package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.ItemType;

@Repository
public interface ItemTypeRepository extends CrudRepository<ItemType, Long> {
}
