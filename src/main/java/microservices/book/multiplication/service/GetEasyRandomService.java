package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.Multiplication;

// multiplicaitionTest2 서비스로부터 REST로 랜덤숫자를 받아와서 UI에 리턴하는 서비스
public interface GetEasyRandomService {

  Multiplication getRandomFactor();
}
