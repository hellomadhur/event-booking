package evnt.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import evnt.domain.ShowTiming;
import evnt.repo.ShowTimingRepo;

@Component
public class ShowTimingConverter implements Converter<Long, ShowTiming> {

	private ShowTimingRepo showTimingRepo;

	@Autowired
	public ShowTimingConverter(ShowTimingRepo showTimingRepo) {
		
		this.showTimingRepo = showTimingRepo;
	}

	@Override
	public ShowTiming convert(Long id) {
		
		return showTimingRepo.findById(id).orElse(null);
	}
	
	
	
	
}
