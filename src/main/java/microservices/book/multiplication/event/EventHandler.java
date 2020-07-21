package microservices.book.multiplication.event;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import microservices.book.multiplication.service.UserService;

/**
 * 이벤트를 받고 연관된 비즈니스 로직을 동작시킴
 */
@Slf4j
@Component
class EventHandler {

	private UserService userService;
  

  EventHandler(final UserService userService) {
    this.userService = userService;
  }

  @RabbitListener(queues = "${multiplication.queue}")
  void handleMultiplicationSolved(final SolvedEvent event) {
    log.info("Multiplication Solved Event 수신: {}", event.toString());
    
    try {
    	userService.save(event.getUserName(), event.isCorrect());
    } catch (final Exception e) {
      log.error("MultiplicationSolvedEvent 처리 시 에러", e);
      // 해당 이벤트가 다시 큐로 들어가거나 두 번 처리되지 않도록 예외 발생
      throw new AmqpRejectAndDontRequeueException(e);
    }
  }

}
