package dev.bstk.fas.pagamento.infra.messagebroker;

public interface MessageBrokerConsumer {

  void consumirEvento(final MessageBrokerEvento evento);
}
