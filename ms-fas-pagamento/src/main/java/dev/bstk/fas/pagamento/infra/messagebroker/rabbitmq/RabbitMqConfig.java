package dev.bstk.fas.pagamento.infra.messagebroker.rabbitmq;

import dev.bstk.fas.pagamento.common.ObjectMapperFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableRabbit
@Configuration
@RequiredArgsConstructor
public class RabbitMqConfig {

  private final RabbitMqProperties properties;

  @Bean
  public Queue queue() {
    return QueueBuilder.durable(properties.getQueue()).build();
  }

  @Bean
  public FanoutExchange exchange() {
    return ExchangeBuilder.fanoutExchange(properties.getExchange())
            .durable(properties.isDuravel())
            .build();
  }

  @Bean
  public Binding binding(final Queue queue, final FanoutExchange exchange) {
    return BindingBuilder.bind(queue).to(exchange);
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter(ObjectMapperFactory.OBJECT_MAPPER);
  }
}
