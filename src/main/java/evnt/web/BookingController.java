package evnt.web;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import evnt.domain.Booking;
import evnt.domain.Event;
import evnt.domain.EventPlace;
import evnt.repo.BookingRepo;

@Controller
@RequestMapping("/booking")
public class BookingController {

	private static final String BOOKING_SUCCESSFUL = "BOOKING SUCCESSFUL";
	private static final String BOOKING_FAILED = "BOOKING FAILED";
	
	private final BookingRepo bookingRepo;
	
	@Autowired
	public BookingController(BookingRepo bookingRepo) {
		
		this.bookingRepo = bookingRepo;
	}

	@PostMapping(consumes = {"text/plain", "application/*", "multipart/form-data"})
	@ResponseBody
	public Map<String, String> bookTickets(Booking booking) {
		
		String bookingMessage;
		
		
		if(booking.getUser() == null 
				|| booking.getShowTiming() == null
				|| booking.getSeatNumber() == null)
		{
			
			bookingMessage = buildErrorMessage(booking);
			
		}else {
			
			bookingMessage = getBookingConfirmation(booking);
		}
		
		booking.setMessage(bookingMessage);
		
		Map<String, String> mapMessage = buildResponseMap(booking);
		
		return mapMessage;
	}
	
	private String buildErrorMessage(Booking booking) {
		
		StringBuilder message = new StringBuilder("Not Booked :( [ ");
		
		if(booking.getUser() == null) message.append("User is null, ");
		if(booking.getShowTiming() == null) message.append("Show Timing is null, ");
		if(booking.getSeatNumber() == null) message.append("Seat Number is null ]");
		
		return message.toString();
	}
	
	private String getBookingConfirmation(Booking booking) {
		
		
		booking.setIsActive(true);
		
		try {
			
			bookingRepo.save(booking);
			
		}catch(Exception ex) {
			
			return BOOKING_FAILED;
		}
		
		return BOOKING_SUCCESSFUL;
	}
	
	private Map<String,String> buildResponseMap(Booking booking){
		
		Map<String, String> mapMessage = new LinkedHashMap<>();
		
		mapMessage.put("Message", booking.getMessage());
		mapMessage.put("Name", booking.getUser().getName());
		Event.Type eventType = booking.getShowTiming().getEvent().getType();
		mapMessage.put(eventType.toString(), booking.getShowTiming().getEvent().getName());
		EventPlace.Type eventPlaceType = booking.getShowTiming().getEventPlace().getType();
		mapMessage.put(eventPlaceType.toString(), booking.getShowTiming().getEventPlace().getName());
		mapMessage.put("Seats", booking.getSeatNumber());
		mapMessage.put("Date", booking.getShowTiming().getShowDate());
		mapMessage.put("Time", booking.getShowTiming().getStartTime());
		mapMessage.put("Screen Name", booking.getShowTiming().getScreenName());
		mapMessage.put("City", booking.getShowTiming().getEventPlace().getCity());
		
		return mapMessage;
	}
}