## 🚚 **7. Entrega**

**Funções principais:**

* Acompanhar transporte até o cliente.
* Registrar status (em trânsito, entregue, falha de entrega).
* Emitir eventos: `EntregaConcluida`, `EntregaFalhou`.

**Regras de negócio:**

1. Entrega só pode ser iniciada após `PedidoExpedido`.
2. Deve existir rastreamento vinculado a cada pedido entregue.
3. Entregas falhas devem gerar evento de reentrega ou devolução.
4. Pedido só muda para `FINALIZADO` após confirmação de entrega.
5. SLA de entrega deve ser monitorado para alertas de atraso.
