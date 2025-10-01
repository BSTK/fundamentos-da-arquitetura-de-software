CREATE TYPE pedido_status AS ENUM (
    'PENDENTE_PAGAMENTO',
    'PAGO',
    'CANCELADO',
    'EXPEDIDO',
    'ENTREGUE'
);

CREATE TABLE Pedidos (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    cliente_id UUID NOT NULL,
    valor_total NUMERIC(10, 2) NOT NULL,
    endereco_entrega JSONB NOT NULL,
    status pedido_status NOT NULL DEFAULT 'PENDENTE_PAGAMENTO',
    data_criacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    data_atualizacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE ItensPedido (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pedido_id UUID NOT NULL,
    livro_id UUID NOT NULL,
    titulo VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL CHECK (quantidade > 0),
    preco_unitario NUMERIC(10, 2) NOT NULL,
    subtotal NUMERIC(10, 2) NOT NULL,
    CONSTRAINT fk_pedido
        FOREIGN KEY(pedido_id) 
        REFERENCES Pedidos(id)
        ON DELETE CASCADE
);

CREATE INDEX idx_pedidos_cliente_id ON Pedidos(cliente_id);
CREATE INDEX idx_pedidos_status ON Pedidos(status);
CREATE INDEX idx_itenspedido_pedido_id ON ItensPedido(pedido_id);
CREATE INDEX idx_itenspedido_livro_id ON ItensPedido(livro_id);

