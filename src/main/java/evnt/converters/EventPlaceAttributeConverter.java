package evnt.converters;

import java.util.stream.Stream;

import evnt.domain.EventPlace;
import evnt.domain.EventPlace.Type;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EventPlaceAttributeConverter implements AttributeConverter<EventPlace.Type, String> {

	@Override
	public String convertToDatabaseColumn(Type type) {
		
		if(type == null) return null;
		return type.toString();
	}

	@Override
	public Type convertToEntityAttribute(String dbData) {
		
		if(dbData == null) return null;
		
		return Stream.of(EventPlace.Type.values())
				.filter(x -> x.toString().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
