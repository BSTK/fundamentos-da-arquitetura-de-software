## 📦 **6. Expedição**

**Funções principais:**

* Separar, embalar e despachar livros.
* Gerar etiquetas de transporte.
* Emitir eventos: `PedidoExpedido`.

**Regras de negócio:**

1. Só expedir pedidos com `PagamentoAprovado` e `ReservaConfirmada`.
2. Cada pedido deve ser associado a um código de rastreamento.
3. Não é permitido expedir parcialmente sem regra de negócio definida.
4. O tempo máximo entre pagamento aprovado e expedição deve ser respeitado (SLA).
5. Expedição falha deve gerar reprocesso automático ou alerta manual.
6. 