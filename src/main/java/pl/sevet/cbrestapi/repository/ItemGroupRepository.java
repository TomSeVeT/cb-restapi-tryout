package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.ItemGroup;

@Repository
public interface ItemGroupRepository extends CrudRepository<ItemGroup, Long> {
}
