package evnt.domain;

import org.springframework.format.annotation.DateTimeFormat;

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
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name", "release_date","type"}))
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long Id;
	
	@Column(nullable = false)
	private final String name;
	
	@Column(name = "release_date", nullable = false)
	@DateTimeFormat(pattern = "dd-MM-YYYY")
	private final String releaseDate;
	
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
