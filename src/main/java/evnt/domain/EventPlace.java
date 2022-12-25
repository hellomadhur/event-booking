package evnt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "EVENT_PLACE")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name","type","city","state","country","zip"}))
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class EventPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	@Column(nullable = false)
	private final String name;
	
	@Column(nullable = false)
	private final Type type;
	private final String description;
	
	@Column(nullable = false)
	private final String country;
	
	@Column(nullable = false)
	private final String State;
	
	@Column(nullable = false)
	private final String city;
	
	@Column(nullable = false)
	private final String address;
	private final long zip;
	private final long phoneNumber;
	private final String mapLocation;
	
	@Column(nullable = false)
	private final boolean isActive;
	
	public enum Type {
		THEATRE, STADIUM, CAFE, RESTAURANT, OTHER;
	}
	
	
}
