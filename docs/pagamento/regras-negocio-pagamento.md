## 💳 **2. Pagamento**

**Funções principais:**

* Processar pagamento (cartão, PIX, boleto, etc.).
* Validar dados financeiros.
* Emitir eventos: `PagamentoAprovado`, `PagamentoRecusado`.

**Regras de negócio:**

1. O pedido só pode seguir para expedição se o pagamento for aprovado.
2. Pagamentos recusados devem alterar o status do pedido para `CANCELADO`.
3. Boletos e PIX têm prazo de expiração; pedidos vencidos devem ser cancelados.
4. Apenas pedidos no status `PENDENTE_PAGAMENTO` podem receber pagamento.
5. Pagamento duplicado para o mesmo pedido deve ser rejeitado.
