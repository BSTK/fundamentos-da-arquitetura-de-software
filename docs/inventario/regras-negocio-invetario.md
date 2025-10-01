## 📚 **3. Inventário** (catálogo de produtos e disponibilidade lógica)

**Funções principais:**

* Verificar disponibilidade de livros (estoque lógico).
* Reservar unidades quando o pedido é criado.
* Emitir eventos: `ReservaConfirmada`, `ReservaNegada`.

**Regras de negócio:**

1. A reserva só é concluída se a quantidade pedida ≤ quantidade disponível.
2. Produtos sem estoque devem disparar `ReservaNegada`.
3. Reserva expira se o pagamento não for confirmado em até X minutos.
4. Apenas pedidos `PENDENTE_PAGAMENTO` podem ter reserva de estoque.
5. Estoque reservado não pode ser consumido por outro pedido até expiração ou cancelamento.
