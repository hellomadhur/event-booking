package evnt.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import evnt.domain.Booking;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Long> {

}
