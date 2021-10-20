package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends CrudRepository<Item, Long> {

    List<Item> findAllByQuantityGreaterThan(float quantity);

    List<Item> findAllByQuantityIs(float quantity);

    List<Item> findAllByLocationId(Long locationId);

    List<Item> findAllByLocationIdAndQuantityGreaterThan(Long typeId, float quantity);

    List<Item> findAllByLocationIdAndQuantityIs(Long typeId, float quantity);

    List<Item> findAllByTypeId(Long typeId);

    List<Item> findAllByTypeIdAndQuantityGreaterThan(Long typeId, float quantity);

    List<Item> findAllByTypeIdAndQuantityIs(Long typeId, float quantity);

    void deleteAllByTypeId(Long typeId);

}
