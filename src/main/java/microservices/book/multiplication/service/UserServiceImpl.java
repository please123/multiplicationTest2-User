package microservices.book.multiplication.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import microservices.book.multiplication.domain.User;
import microservices.book.multiplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private UserRepository userRepository;
	
	@Autowired
	public UserServiceImpl(final UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	@Override
	public void save(String userName, boolean correct) {
		
		User user = new User(userName, correct);
		logger.info("user :" + user.toString());
		
		userRepository.save(user);
	}


}
