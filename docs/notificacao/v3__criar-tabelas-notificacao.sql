CREATE TYPE notificacao_tipo AS ENUM (
    'EMAIL',
    'SMS',
    'PUSH'
);

CREATE TYPE notificacao_status AS ENUM (
    'PENDENTE',
    'ENVIADA',
    'FALHA'
);

CREATE TABLE Notificacoes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL,
    cliente_id UUID NOT NULL,
    tipo notificacao_tipo NOT NULL,
    assunto VARCHAR(255) NOT NULL,
    mensagem TEXT NOT NULL,
    status notificacao_status NOT NULL DEFAULT 'PENDENTE',
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_envio TIMESTAMP WITH TIME ZONE
);

CREATE INDEX idx_notificacoes_pedido_id ON Notificacoes(pedido_id);
CREATE INDEX idx_notificacoes_cliente_id ON Notificacoes(cliente_id);
CREATE INDEX idx_notificacoes_status ON Notificacoes(status);
