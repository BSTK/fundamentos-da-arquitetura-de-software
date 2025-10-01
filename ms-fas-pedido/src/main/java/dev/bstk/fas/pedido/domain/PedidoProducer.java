package dev.bstk.fas.pedido.domain;

import dev.bstk.fas.pedido.domain.event.PedidoCriadoEvent;
import dev.bstk.fas.pedido.infra.messagebroker.Producer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoProducer implements Producer<PedidoCriadoEvent> {

  private final RabbitTemplate rabbitTemplate;

  @Override
  public void enviarEvento(final PedidoCriadoEvent evento) {
    log.info("Inicio - [método]=enviarEvento, evento={}", evento);

    rabbitTemplate.convertAndSend("pedido-evento", evento);

    log.info("Fim - [método]=enviarEvento, evento={}", evento);
  }
}
