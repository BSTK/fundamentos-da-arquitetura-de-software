package dev.bstk.fas.pedido.infra.messagebroker;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public abstract class MessageBrokerEvento {

  @EqualsAndHashCode.Include
  private final UUID eventId;
  private final LocalDateTime timestamp;

  protected MessageBrokerEvento() {
    this.eventId = UUID.randomUUID();
    this.timestamp = LocalDateTime.now();
  }

  protected abstract Object getPayload();
}
