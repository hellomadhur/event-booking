package evnt.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity	
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@AllArgsConstructor
public class Booking {

	@Transient
	private String message;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private final Long id;
	
	@NotNull
	@Column(nullable = false)
	private final String seatNumber;
	
	@NotNull
	@JoinColumn(name = "user_info_id")
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private final User user;
	
	@NotNull
	@JoinColumn(name = "show_details_id")
	@OneToOne(fetch = FetchType.EAGER, optional = false)
	private final ShowDetails showDetails;
	
	@Column(nullable = false)
	private Boolean isActive;
	
}
