package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sevet.cbrestapi.model.UserAccess;

import java.util.List;

@Repository
public interface UserAccessRepository extends CrudRepository<UserAccess, Long> {
    List<UserAccess> findAllByUserId(Long userId);


    void deleteAllByUserIdAndLocationId(Long userId, Long locationId);
}
