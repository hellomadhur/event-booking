package evnt.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class EventPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	private final String name;
	private final Type type;
	private final String description;
	private final String Country;
	private final String State;
	private final String City;
	private final String Address;
	private final String zip;
	private final long phoneNumber;
	private final String mapLocation;
	private final String isActive;
	
	public enum Type {
		THEATRE, STADIUM, CAFE, RESTAURANT, OTHER;
	}
	
	
}
