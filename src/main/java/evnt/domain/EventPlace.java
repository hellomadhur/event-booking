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
public class EventPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final long id;
	
	@Column(nullable = false)
	private final String name;
	
	@Column(nullable = false)
	private final Type type;
	private final String description;
	
	@Column(nullable = false)
	private final String Country;
	
	@Column(nullable = false)
	private final String State;
	
	@Column(nullable = false)
	private final String City;
	
	@Column(nullable = false)
	private final String Address;
	private final long zip;
	private final long phoneNumber;
	private final String mapLocation;
	
	@Column(nullable = false)
	private final String isActive;
	
	public enum Type {
		THEATRE, STADIUM, CAFE, RESTAURANT, OTHER;
	}
	
	
}
