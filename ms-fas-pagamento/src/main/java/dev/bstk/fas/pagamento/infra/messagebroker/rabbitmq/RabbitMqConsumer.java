package dev.bstk.fas.pagamento.infra.messagebroker.rabbitmq;

import dev.bstk.fas.pagamento.infra.messagebroker.MessageBrokerConsumer;
import dev.bstk.fas.pagamento.infra.messagebroker.MessageBrokerEvento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class RabbitMqConsumer implements MessageBrokerConsumer {

  private final ApplicationEventPublisher eventPublisher;

  @Override
  @RabbitListener(queues = "${msfaspagamento.messagebroker.rabbitmq.pedido-criado.queue}")
  public void consumirEvento(@Payload final MessageBrokerEvento evento) {
    log.info("Inicio - [método]=consumirEvento, event={}", evento);

    eventPublisher.publishEvent(evento);

    log.info("Fim - [método]=consumirEvento, event={}", evento);
  }
}
