package evnt.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import evnt.domain.ShowDetails;
import evnt.repo.ShowDetailsRepo;

@Component
public class ShowDetailsByIdConverter implements Converter<Long, ShowDetails> {

	private ShowDetailsRepo showDetailsRepo;

	@Autowired
	public ShowDetailsByIdConverter(ShowDetailsRepo showDetailsRepo) {
		
		this.showDetailsRepo = showDetailsRepo;
	}

	@Override
	public ShowDetails convert(Long id) {
		
		return showDetailsRepo.findById(id).orElse(null);
	}
	
	
	
	
}
