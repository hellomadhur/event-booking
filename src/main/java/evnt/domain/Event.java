package evnt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	private final String name;
	private final boolean isActive;
	private final Type type;
	private final String description;
	private final String duration;
	
	public enum Type {
		MOVIE,MUSIC,PLAY,SPORT,FESTIVAL,OTHER;
	}
}
