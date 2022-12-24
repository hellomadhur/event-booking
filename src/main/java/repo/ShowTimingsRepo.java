package repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.ShowTimings;

@Repository
public interface ShowTimingsRepo extends CrudRepository<ShowTimings, Long>{

	public List<ShowTimings> findByEventIdAndCountryAndStateAndCityPlacedAtEquals(
			long eventId, String country, String state, String city, Date date);
}
