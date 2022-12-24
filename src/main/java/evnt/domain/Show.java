package evnt.domain;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Show {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	private final Event event;
	private final EventPlace eventPlace;
	private final String startTime;
	private final Date date;
	private final String screen;
	private final boolean isActive;
}
