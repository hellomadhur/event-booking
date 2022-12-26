package evnt.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import evnt.domain.User;
import evnt.repo.UserRepo;

@Component
public class UserByIdConverter implements Converter<Long, User> {

	private UserRepo userRepo;

	@Autowired
	public UserByIdConverter(UserRepo userRepo) {
		this.userRepo = userRepo;
	}

	@Override
	public User convert(Long id) {
		
		return userRepo.findById(id).orElse(null);
	}
	
	
	
}
