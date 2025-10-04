package dev.bstk.fas.pedido.infra.messagebroker.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class RabbitMqProperties {

  @Value("${msfaspedido.messagebroker.pedido.queue}")
  private String queue;

  @Value("${msfaspedido.messagebroker.pedido.exchange}")
  private String exchange;

  @Value("${msfaspedido.messagebroker.pedido.duravel}")
  private boolean duravel;
}