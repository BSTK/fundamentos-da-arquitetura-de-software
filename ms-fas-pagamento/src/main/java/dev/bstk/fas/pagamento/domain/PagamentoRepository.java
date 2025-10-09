package dev.bstk.fas.pagamento.domain;

import dev.bstk.fas.pagamento.domain.entity.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> { }
