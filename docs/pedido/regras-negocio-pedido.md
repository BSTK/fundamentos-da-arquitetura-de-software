## 📦 **1. Pedido**

**Funções principais:**

* Registrar um novo pedido com itens selecionados pelo cliente.
* Associar cliente, itens, valores e endereço de entrega.
* Publicar evento `PedidoCriado`.

**Regras de negócio (até 5):**

1. Um pedido só pode ser criado se tiver pelo menos 1 item válido.
2. O status inicial de um pedido é `PENDENTE_PAGAMENTO`.
3. O valor total do pedido deve ser a soma do preço de capa (ou promocional) × quantidade.
4. Pedido deve estar associado a um cliente válido (CPF/CNPJ ou ID cadastrado).
5. Pedido não pode ser modificado após o pagamento confirmado.
