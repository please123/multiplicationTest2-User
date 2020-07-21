package microservices.book.multiplication.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import microservices.book.multiplication.domain.Multiplication;

@Service
public class GetEasyRandomServiceImpl implements GetEasyRandomService {
	
	private final Logger logger = LoggerFactory.getLogger(GetEasyRandomServiceImpl.class); 

	private final RestTemplate restTemplate;
	private final String multiplicationHost;
	
	
	GetEasyRandomServiceImpl(final RestTemplate restTemplate, 
			@Value("${multiplicationTest2Host}") final String multiplicationHost) {
		 this.restTemplate = restTemplate;
		 this.multiplicationHost = multiplicationHost;
	}
		
	@Override
	public Multiplication getRandomFactor() {
		
		Multiplication multiplication = restTemplate.getForObject(multiplicationHost + "/multiplications/randomeasy", Multiplication.class);
//		return restTemplate.getForObject(multiplicationHost + "/multiplications/randomeasy", Multiplication.class);
		
		logger.info(multiplication.toString());
		
		return multiplication;
	}

}
