package evnt.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class ShowTimings {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	
	@Column(nullable = false)
	private final String startTime;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private final Date date;
	private final String screenNumber;
	
	@Column(nullable = false)
	private final boolean isActive;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private final Event event;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private final EventPlace eventPlace;
}
