package pl.sevet.cbrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pl.sevet.cbrestapi.model.UserSecPass;

import java.util.Optional;

@RepositoryRestResource(exported = false)
public interface UserSecPassRepository extends CrudRepository<UserSecPass, Long> {
    Optional<UserSecPass> findByUserId(Long userId);
}
