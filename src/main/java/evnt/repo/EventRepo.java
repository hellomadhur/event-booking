package evnt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {

	public Event findByNameIgnoringCase(String name);

}
