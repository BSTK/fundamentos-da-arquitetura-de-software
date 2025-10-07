package dev.bstk.fas.pedido.infra.messagebroker.rabbitmq;

import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerEvento;
import dev.bstk.fas.pedido.infra.messagebroker.MessageBrokerProduce;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqProducer implements MessageBrokerProduce {

  private final RabbitTemplate rabbitTemplate;
  private final RabbitMqProperties properties;

  @Override
  public void publicarEvento(MessageBrokerEvento evento) {
    log.info("Inicio - [método]=enviarEvento, evento={}", evento);

    rabbitTemplate.convertAndSend(properties.getExchange(), StringUtils.EMPTY, evento);

    log.info("Fim - [método]=enviarEvento, evento={}", evento);
  }
}
