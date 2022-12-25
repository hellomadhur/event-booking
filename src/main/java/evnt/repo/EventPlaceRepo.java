package evnt.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.EventPlace;

@Repository
public interface EventPlaceRepo extends CrudRepository<EventPlace, Long> {

	List<EventPlace> findByCity(String city);
}
