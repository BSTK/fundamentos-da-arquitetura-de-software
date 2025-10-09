package dev.bstk.fas.pagamento.infra.messagebroker.rabbitmq;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
public class RabbitMqProperties {

  @Value("${msfaspagamento.messagebroker.rabbitmq.pedido-criado.exchange}")
  private String exchange;

  @Value("${msfaspagamento.messagebroker.rabbitmq.pedido-criado.queue}")
  private String queue;

  @Value("${msfaspagamento.messagebroker.rabbitmq.pedido-criado.duravel}")
  private boolean duravel;
}
