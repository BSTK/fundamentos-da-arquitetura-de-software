package dev.bstk.fas.pagamento.domain.event;

import dev.bstk.fas.pagamento.common.ObjectMapperFactory;
import dev.bstk.fas.pagamento.infra.messagebroker.MessageBrokerEvento;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PedidoListener {

  @SneakyThrows
  @EventListener(MessageBrokerEvento.class)
  public void pedidoCriado(final MessageBrokerEvento evento) {
    log.info("Inicio - [método]=pedidoCriado, evento={}", evento);

    final var payload = ObjectMapperFactory.OBJECT_MAPPER.writeValueAsString(evento.getPayload());
    final var pedidoCriadoEvent = ObjectMapperFactory.OBJECT_MAPPER.readValue(payload, PedidoCriadoEvent.class);

    log.info("Fim - [método]=pedidoCriado, evento={}, pedidoCriadoEvent={}", evento, pedidoCriadoEvent);
  }
}
