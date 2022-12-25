package evnt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import evnt.domain.Event;
import evnt.domain.EventPlace;
import evnt.domain.ShowTiming;
import evnt.repo.EventPlaceRepo;
import evnt.repo.EventRepo;
import evnt.repo.ShowTimingRepo;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class StartupRunner implements ApplicationRunner {

	private EventRepo eventRepo;
	private EventPlaceRepo eventPlaceRepo;
	private ShowTimingRepo showTimingRepo;
	
	
	public StartupRunner(EventRepo eventRepo, EventPlaceRepo eventPlaceRepo, ShowTimingRepo showTimingRepo) {
		super();
		this.eventRepo = eventRepo;
		this.eventPlaceRepo = eventPlaceRepo;
		this.showTimingRepo = showTimingRepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		populateShowTimings();

	}
	
public void populateShowTimings() {
		
		Iterable<Event> eventList = eventRepo.findAll();
		Iterable<EventPlace> eventPlaceList = eventPlaceRepo.findAll();
				
		ShowTiming show;
		DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
		LocalDateTime now = LocalDateTime.now();
		String[] showTimes = {"10:00 am", "1:30 pm", "5:00 pm", "9:00 pm"};
		int screenNumber = 1;
		Random random = new Random();
		for (Event event : eventList) {
			
			String showDate = dtFormatter.format(now.plusDays(3)).toString();
			for (EventPlace eventPlace : eventPlaceList) {
				
				for(String time : showTimes) {
					
					if(random.nextInt(50) % 2 == 0){
						String screenName = "Screen "+screenNumber;
						show = new ShowTiming(null, time, showDate, screenName, true, event, eventPlace);
						showTimingRepo.save(show);
					}
					
				}
			}
			screenNumber++;
		}
	}
}
