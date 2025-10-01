## 📢 **5. Notificação**

**Funções principais:**

* Enviar comunicações ao cliente (e-mail, SMS, push).
* Emitir eventos de comunicação: `NotificacaoEnviada`.

**Regras de negócio:**

1. Enviar confirmação de pedido (`PedidoCriado`).
2. Enviar confirmação de pagamento aprovado ou recusado.
3. Enviar aviso de expedição e código de rastreio.
4. Enviar confirmação de entrega finalizada.
5. Notificações não críticas podem ser reprocessadas em caso de falha.
