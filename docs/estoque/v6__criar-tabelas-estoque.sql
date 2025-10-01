CREATE TABLE Estoques (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    produto_id UUID NOT NULL UNIQUE,
    quantidade_atual INT NOT NULL CHECK (quantidade_atual >= 0),
    localizacao VARCHAR(255),
    data_atualizacao TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_produto
        FOREIGN KEY(produto_id)
        REFERENCES Produtos(id)
        ON DELETE CASCADE
);

CREATE TYPE movimentacao_tipo AS ENUM (
    'ENTRADA',
    'SAIDA',
    'AJUSTE'
);

CREATE TABLE MovimentacoesEstoque (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    produto_id UUID NOT NULL,
    pedido_id UUID,
    tipo movimentacao_tipo NOT NULL,
    quantidade INT NOT NULL,
    motivo VARCHAR(255),
    data_hora TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_produto_movimentacao
        FOREIGN KEY(produto_id)
        REFERENCES Produtos(id)
        ON DELETE RESTRICT
);

CREATE INDEX idx_estoques_produto_id ON Estoques(produto_id);
CREATE INDEX idx_movimentacoes_estoque_produto_id ON MovimentacoesEstoque(produto_id);
CREATE INDEX idx_movimentacoes_estoque_pedido_id ON MovimentacoesEstoque(pedido_id);
CREATE INDEX idx_movimentacoes_estoque_tipo ON MovimentacoesEstoque(tipo);
