package microservices.book.multiplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import microservices.book.multiplication.domain.Multiplication;
import microservices.book.multiplication.service.GetEasyRandomService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 곱셈 애플리케이션의 REST API 를 구현한 클래스
 */
@RestController
@RequestMapping("/multiplications")
final class MultiplicationController {
	
	private final Logger logger = LoggerFactory.getLogger(MultiplicationController.class); 

	private final GetEasyRandomService easyRandomService;

  @Autowired
  	public MultiplicationController(final GetEasyRandomService easyRandomService) {
	  this.easyRandomService = easyRandomService;
  }

  @CrossOrigin
  @GetMapping("/easy")
	Multiplication getEasyRanmdomMultiplication() {
	  return easyRandomService.getRandomFactor();
	}

}
