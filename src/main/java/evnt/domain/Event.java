package evnt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	
	@Column(nullable = false)
	private final String name;
	
	@Column(nullable = false)
	private final Boolean isActive;
	
	@Column(nullable = false)
	private final Type type;
	private final String description;
	private final String duration;
	
	public enum Type {
		MOVIE,MUSIC,PLAY,SPORT,FESTIVAL,OTHER;
	}
}
