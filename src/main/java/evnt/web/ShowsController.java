package evnt.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import evnt.domain.Event;
import evnt.domain.EventPlace;
import evnt.domain.ShowTiming;
import evnt.repo.EventPlaceRepo;
import evnt.repo.EventRepo;
import evnt.repo.ShowTimingRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shows")
public class ShowsController {

	private EventRepo eventRepo;
	private EventPlaceRepo eventPlaceRepo;
	private ShowTimingRepo showTimingRepo;
	
	
	@Autowired
	public ShowsController(EventRepo eventRepo, EventPlaceRepo eventPlaceRepo, ShowTimingRepo showTimingRepo) {
		this.eventRepo = eventRepo;
		this.eventPlaceRepo = eventPlaceRepo;
		this.showTimingRepo = showTimingRepo;
	}

	@GetMapping
	@ResponseBody
	public Map<String, List<String>> getShows(
			@RequestParam String movie, 
			@RequestParam String date,
			@RequestParam String city){
		
		Event event = eventRepo.findByNameIgnoringCase(movie);
		
		 List<ShowTiming> showsList = showTimingRepo.findByEventAndShowDate(event, date);
		 
		 Map<String, List<String>> showMap = new HashMap<>();
		 List<String> listTimeSlots;
		 String eventPlaceName;
		 
		 for (ShowTiming show : showsList) {
			
			 if(show.getEventPlace().getCity().equalsIgnoreCase(city)) {
				 
				 eventPlaceName = show.getEventPlace().getName();
				 listTimeSlots  = showMap.get(eventPlaceName);
				 
				 if(listTimeSlots == null) {
					 listTimeSlots = new ArrayList<String>();
				 }
				 
				 listTimeSlots.add(show.getStartTime());
				 
				 showMap.put(eventPlaceName, listTimeSlots);
			 }
		 }

		 log.info("List: {}", showMap);
		return showMap;
	}
}
