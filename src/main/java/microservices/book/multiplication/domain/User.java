package microservices.book.multiplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 사용자 정보와 정답여부를 저장하는 클래스
 */
//@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class User {

	@Id
	@GeneratedValue
	private Long userId;
	
	private final String userName;
	private final boolean correct;

  // JSON (역)직렬화를 위한 빈 생성자
  protected User() {
    userName = null;
    correct = false;
  }
  
  public User(String userName, boolean correct) {
	  this.userName = userName;
	  this.correct = correct;
  }
}
