package dev.bstk.fas.pedido.infra.messagebroker;

public interface Producer<T> {

  void enviarEvento(T evento);
}
