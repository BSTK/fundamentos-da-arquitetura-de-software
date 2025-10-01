### 📢 Entidades (Notificação)

```json
{
  "Notificacao": {
    "id": "UUID",
    "pedidoId": "UUID",
    "clienteId": "UUID",
    "tipo": "string (EMAIL | SMS | PUSH)",
    "assunto": "string",
    "mensagem": "string",
    "status": "string (PENDENTE | ENVIADA | FALHA)",
    "dataCriacao": "datetime",
    "dataEnvio": "datetime"
  }
}
```

---

### 📢 Contratos de Eventos (Notificação)

**NotificacaoEnviada**

```json
{
  "evento": "NotificacaoEnviada",
  "notificacaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "tipo": "string",
  "assunto": "string",
  "dataHora": "datetime"
}
```

**NotificacaoFalhou**

```json
{
  "evento": "NotificacaoFalhou",
  "notificacaoId": "UUID",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "tipo": "string",
  "motivo": "string",
  "dataHora": "datetime"
}
```

**NotificacaoPedidoCriado**

```json
{
  "evento": "NotificacaoPedidoCriado",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "mensagem": "string",
  "dataHora": "datetime"
}
```

**NotificacaoPagamentoAtualizado**

```json
{
  "evento": "NotificacaoPagamentoAtualizado",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "statusPagamento": "string (APROVADO | RECUSADO | EXPIRADO)",
  "mensagem": "string",
  "dataHora": "datetime"
}
```

**NotificacaoEntregaAtualizada**

```json
{
  "evento": "NotificacaoEntregaAtualizada",
  "pedidoId": "UUID",
  "clienteId": "UUID",
  "statusEntrega": "string (EXPEDIDO | EM_TRANSITO | ENTREGUE | FALHA)",
  "mensagem": "string",
  "dataHora": "datetime"
}
```
