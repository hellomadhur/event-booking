package evnt.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import evnt.domain.ShowDetails;
import evnt.repo.EventRepo;
import evnt.repo.ShowDetailsRepo;
import io.micrometer.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shows")
public class ShowsController {

	private EventRepo eventRepo;
	private ShowDetailsRepo showDetailsRepo;
	
	
	@Autowired
	public ShowsController(EventRepo eventRepo, ShowDetailsRepo showDetailsRepo) {
		this.eventRepo = eventRepo;
		this.showDetailsRepo = showDetailsRepo;
	}

	@GetMapping
	@ResponseBody
	public Map<String, List<String>> getShows(
			@RequestParam(defaultValue = "null") String movie, 
			@RequestParam(defaultValue = "null") String date,
			@RequestParam(defaultValue = "null") String city){
		
		if(movie.equals("null") || date.equals("null") || city.equals("null")) {
			
			return Collections.singletonMap("Message", Arrays.asList("Movie or Date or City is Not Specified"));
		}
		
		Map<String, List<String>> showMap;
		 
		showMap = getShowsMapForMovie(movie, date, city);
		
		log.info("List: {}", showMap);
		return showMap;
	}
	
	private Map<String, List<String>> getShowsMapForMovie(String movie, String date, String city){
		
		Map<String, List<String>> showMap = new HashMap<>();
		List<String> listTimeSlots;
		String eventPlaceName;	
	 
		Event event = eventRepo.findByNameIgnoringCase(movie);
		List<ShowDetails> showsList = showDetailsRepo.findByEventAndShowDate(event, date);
			 
		 for (ShowDetails show : showsList) {
			
			 if(city!=null && city.equalsIgnoreCase(show.getEventPlace().getCity()) ) {
				 
				 eventPlaceName = show.getEventPlace().getName();
				 listTimeSlots  = showMap.get(eventPlaceName);
				 
				 if(listTimeSlots == null) {
					 listTimeSlots = new ArrayList<String>();
				 }
				 
				 listTimeSlots.add(show.getStartTime());
				 
				 showMap.put(eventPlaceName, listTimeSlots);
			 }
		 }
		 return showMap;
	}
}
