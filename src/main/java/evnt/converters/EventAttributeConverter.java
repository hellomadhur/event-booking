package evnt.converters;
import java.util.stream.Stream;

import jakarta.persistence.Converter;

import evnt.domain.Event;
import jakarta.persistence.AttributeConverter;

@Converter(autoApply = true)

public class EventAttributeConverter implements AttributeConverter<Event.Type, String> {

	@Override
	public String convertToDatabaseColumn(Event.Type type) {
		
		if(type == null) return null;
		return type.toString();
	}

	@Override
	public Event.Type convertToEntityAttribute(String dbData) {
		
		if(dbData == null) return null;
		
		return Stream.of(Event.Type.values())
				.filter(x -> x.toString().equals(dbData))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}

}
