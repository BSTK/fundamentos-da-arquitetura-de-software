package dev.bstk.fas.pedido.infra.messagebroker.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class RabbitMqProperties {

  @Value("${msfaspedido.messagebroker.rabbitmq.pedido.exchange}")
  private String exchange;

  @Value("${msfaspedido.messagebroker.rabbitmq.pedido.duravel}")
  private boolean duravel;
}