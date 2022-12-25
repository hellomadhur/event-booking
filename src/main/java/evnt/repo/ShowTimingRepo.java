package evnt.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.Event;
import evnt.domain.ShowTiming;

@Repository
public interface ShowTimingRepo extends CrudRepository<ShowTiming, Long>{

//	public List<ShowTimings> findByEventIdAndCountryAndStateAndCityPlacedAtEquals(
//			long eventId, String country, String state, String city, Date date);
	
	public List<ShowTiming> findByEvent(Event event);
	public List<ShowTiming> findByShowDate(String date);
	public List<ShowTiming> findByEventAndShowDate(Event event, String showDate);
}
