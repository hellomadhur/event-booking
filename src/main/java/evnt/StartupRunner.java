package evnt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import evnt.domain.Event;
import evnt.domain.EventPlace;
import evnt.domain.ShowDetails;
import evnt.repo.EventPlaceRepo;
import evnt.repo.EventRepo;
import evnt.repo.ShowDetailsRepo;

@Component
public class StartupRunner implements ApplicationRunner {

	private EventRepo eventRepo;
	private EventPlaceRepo eventPlaceRepo;
	private ShowDetailsRepo showDetailsRepo;
	
	
	public StartupRunner(EventRepo eventRepo, EventPlaceRepo eventPlaceRepo, ShowDetailsRepo showDetailsRepo) {
		super();
		this.eventRepo = eventRepo;
		this.eventPlaceRepo = eventPlaceRepo;
		this.showDetailsRepo = showDetailsRepo;
	}


	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		populateShowTimings();

	}
	
	public void populateShowTimings() {
			
			Iterable<Event> eventList = eventRepo.findAll();
			Iterable<EventPlace> eventPlaceList = eventPlaceRepo.findAll();
					
			ShowDetails show;
			DateTimeFormatter dtFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
			LocalDateTime now = LocalDateTime.now();
			String[] showTimes = {"10:00 am", "1:30 pm", "5:00 pm", "9:00 pm"};
			int screenNumber = 1;
			Random random = new Random();
			String showDate;
			
			for(int i=1;i<8;i++) {
				for (Event event : eventList) {
					
					showDate = dtFormatter.format(now.plusDays(i)).toString();
					for (EventPlace eventPlace : eventPlaceList) {
						
						for(String time : showTimes) {
							
							if(random.nextInt(50) % 2 == 0){
								String screenName = "Screen "+screenNumber;
								show = new ShowDetails(null, time, showDate, screenName, true, event, eventPlace);
								showDetailsRepo.save(show);
							}
						}
					}
					screenNumber++;
				}
			}
		}
}
