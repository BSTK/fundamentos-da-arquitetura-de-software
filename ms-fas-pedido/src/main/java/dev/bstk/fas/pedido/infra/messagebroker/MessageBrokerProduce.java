package dev.bstk.fas.pedido.infra.messagebroker;

public interface MessageBrokerProduce {

  void publicarEvento(final MessageBrokerEvento evento);
}
