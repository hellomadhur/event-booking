package evnt.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.Event;
import evnt.domain.ShowDetails;

@Repository
public interface ShowDetailsRepo extends CrudRepository<ShowDetails, Long>{

	public List<ShowDetails> findByEvent(Event event);
	public List<ShowDetails> findByShowDate(String date);
	public List<ShowDetails> findByEventAndShowDate(Event event, String showDate);
}
