package dev.bstk.fas.pedido.infra.messagebroker.config;

import dev.bstk.fas.pedido.common.ObjectMapperFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
    return new Queue(properties.getQueue(), properties.isDuravel());
  }

  @Bean
  public DirectExchange exchange() {
    return new DirectExchange(properties.getExchange());
  }

  @Bean
  public Binding binding() {
    return BindingBuilder.bind(queue()).to(exchange()).withQueueName();
  }

  @Bean
  public MessageConverter jsonMessageConverter() {
    return new Jackson2JsonMessageConverter(ObjectMapperFactory.OBJECT_MAPPER);
  }
}
