package microservices.book.multiplication.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * 사용자 이름과 점수를 저장하는 클래스
 */
//@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Entity
public final class UserScore {

	@Id
	@GeneratedValue
	private Long Id;
	
	private final String userName;
	private final int score;

  // JSON (역)직렬화를 위한 빈 생성자
  protected UserScore() {
    this(null, -1);
  }
  
  public UserScore(String userName, int score) {
	  this.userName = userName;
	  this.score = score;
  }
}
