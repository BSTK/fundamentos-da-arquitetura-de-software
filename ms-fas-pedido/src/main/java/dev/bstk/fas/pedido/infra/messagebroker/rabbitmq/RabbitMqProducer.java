package dev.bstk.fas.pedido.infra.messagebroker.rabbitmq;

import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerEvento;
import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerProduce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqProducer implements MessageBrokerProduce {

  private final RabbitTemplate rabbitTemplate;

  @Override
  public void publicarEvento(MessageBrokerEvento messageBrokerEvento) {
    log.info("Inicio - [método]=enviarEvento, evento={}", messageBrokerEvento);

    rabbitTemplate.convertAndSend(messageBrokerEvento);

    log.info("Fim - [método]=enviarEvento, evento={}", messageBrokerEvento);
  }
}
