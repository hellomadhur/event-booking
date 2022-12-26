package evnt.domain;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Entity(name = "SHOW_TIMING")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"show_date","start_time","event_id","event_place_id"}))
public class ShowTiming {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	
	@Column(name = "start_time", nullable = false)
	private final String startTime;
	
	@Column(name = "show_date", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private final String showDate;
	
	@Column(name = "screen_name", nullable = false)
	private final String screenName;
	
	@Column(nullable = false)
	private final boolean isActive;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "event_id")
	private Event event;
	
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "event_place_id")
	private EventPlace eventPlace;
}
