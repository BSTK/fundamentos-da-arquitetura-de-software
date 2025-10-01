### 🏬 Entidades (Estoque - físico)

```json
{
  "Estoque": {
    "id": "UUID",
    "produtoId": "UUID",
    "quantidadeAtual": "int",
    "localizacao": "string",
    "dataAtualizacao": "datetime"
  },
  "MovimentacaoEstoque": {
    "id": "UUID",
    "produtoId": "UUID",
    "pedidoId": "UUID",
    "tipo": "string (ENTRADA | SAIDA | AJUSTE)",
    "quantidade": "int",
    "motivo": "string",
    "dataHora": "datetime"
  }
}
```

---

### 📢 Contratos de Eventos (Estoque)

**EstoqueBaixado**

```json
{
  "evento": "EstoqueBaixado",
  "produtoId": "UUID",
  "pedidoId": "UUID",
  "quantidade": "int",
  "quantidadeRestante": "int",
  "dataHora": "datetime"
}
```

**EstoqueReposto**

```json
{
  "evento": "EstoqueReposto",
  "produtoId": "UUID",
  "quantidadeAdicionada": "int",
  "quantidadeTotal": "int",
  "dataHora": "datetime",
  "origem": "string (FORNECEDOR | DEVOLUCAO | AJUSTE)"
}
```

**EstoqueInsuficiente**

```json
{
  "evento": "EstoqueInsuficiente",
  "produtoId": "UUID",
  "pedidoId": "UUID",
  "quantidadeSolicitada": "int",
  "quantidadeDisponivel": "int",
  "dataHora": "datetime"
}
```

**AjusteEstoqueRealizado**

```json
{
  "evento": "AjusteEstoqueRealizado",
  "produtoId": "UUID",
  "quantidadeAnterior": "int",
  "quantidadeAjustada": "int",
  "quantidadeFinal": "int",
  "motivo": "string (PERDA | INVENTARIO | CORRECAO)",
  "dataHora": "datetime"
}
```

**DevolucaoProcessada**

```json
{
  "evento": "DevolucaoProcessada",
  "produtoId": "UUID",
  "pedidoId": "UUID",
  "quantidade": "int",
  "quantidadeTotal": "int",
  "dataHora": "datetime"
}
```
