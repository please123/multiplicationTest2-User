package microservices.book.multiplication.service;

import microservices.book.multiplication.domain.User;

public interface UserService {
	
	// 이벤트로 받은 사용자 정보를 저장 
	void save(String userId, boolean correct);
	
	
}
