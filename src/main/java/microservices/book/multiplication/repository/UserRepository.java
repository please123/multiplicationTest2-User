package microservices.book.multiplication.repository;
import org.springframework.data.repository.CrudRepository;

import microservices.book.multiplication.domain.User;



/**
 * 답안을 저장하고 조회하기 위한 인터페이스
 */
public interface UserRepository extends CrudRepository<User, Long> {
	

}
