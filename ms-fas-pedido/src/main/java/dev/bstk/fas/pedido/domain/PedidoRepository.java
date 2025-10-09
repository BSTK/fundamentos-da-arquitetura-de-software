package dev.bstk.fas.pedido.domain;

import dev.bstk.fas.pedido.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  @Query("SELECT p FROM Pedido p JOIN FETCH p.itens")
  List<Pedido> listarPedidos();

  @Query("SELECT p FROM Pedido p JOIN FETCH p.itens WHERE p.clienteUuid =:clienteId")
  List<Pedido> buscarPedidosPorCliente(UUID clienteId);
}
