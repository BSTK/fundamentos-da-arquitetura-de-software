### 📚 Entidades (Inventário)

```json
{
  "Produto": {
    "id": "UUID",
    "titulo": "string",
    "autor": "string",
    "isbn": "string",
    "preco": "decimal",
    "quantidadeDisponivel": "int",
    "ativo": "boolean",
    "dataAtualizacao": "datetime"
  },
  "ReservaEstoque": {
    "id": "UUID",
    "pedidoId": "UUID",
    "produtoId": "UUID",
    "quantidade": "int",
    "status": "string (RESERVADO | NEGADO | EXPIRADO | CONSUMIDO | CANCELADO)",
    "dataCriacao": "datetime",
    "dataExpiracao": "datetime"
  }
}
```

---

### 📢 Contratos de Eventos (Inventário)

**ReservaCriada**

```json
{
  "evento": "ReservaCriada",
  "reservaId": "UUID",
  "pedidoId": "UUID",
  "produtoId": "UUID",
  "quantidade": "int",
  "status": "RESERVADO",
  "dataHora": "datetime"
}
```

**ReservaConfirmada**

```json
{
  "evento": "ReservaConfirmada",
  "reservaId": "UUID",
  "pedidoId": "UUID",
  "itens": [
    {
      "produtoId": "UUID",
      "quantidade": "int"
    }
  ],
  "dataHora": "datetime"
}
```

**ReservaNegada**

```json
{
  "evento": "ReservaNegada",
  "reservaId": "UUID",
  "pedidoId": "UUID",
  "produtoId": "UUID",
  "quantidadeSolicitada": "int",
  "quantidadeDisponivel": "int",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**ReservaExpirada**

```json
{
  "evento": "ReservaExpirada",
  "reservaId": "UUID",
  "pedidoId": "UUID",
  "produtoId": "UUID",
  "quantidade": "int",
  "dataHora": "datetime"
}
```

**EstoqueAtualizado**

```json
{
  "evento": "EstoqueAtualizado",
  "produtoId": "UUID",
  "quantidadeAnterior": "int",
  "quantidadeAtual": "int",
  "motivo": "string (RESERVA | CANCELAMENTO | REPOSICAO)",
  "dataHora": "datetime"
}
```
