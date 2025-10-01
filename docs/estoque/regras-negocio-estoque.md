## 🏬 **4. Estoque** (controle físico no armazém)

**Funções principais:**

* Atualizar quantidade real após reserva confirmada.
* Baixar unidades do estoque após expedição.
* Emitir eventos: `EstoqueBaixado`, `EstoqueInsuficiente`.

**Regras de negócio:**

1. O estoque físico deve ser reduzido somente após expedição confirmada.
2. Divergência entre inventário e estoque deve gerar alerta.
3. Retornos (devoluções) devem reverter estoque.
4. Estoque negativo não é permitido.
5. Atualização de estoque deve ser idempotente (sem duplicar baixas).