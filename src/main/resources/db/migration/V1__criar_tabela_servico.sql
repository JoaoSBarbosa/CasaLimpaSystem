CREATE TABLE `servico` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `horas_banheiro` int NOT NULL,
    `horas_cozinha` int NOT NULL,
    `horas_outros` int NOT NULL,
    `horas_quarto` int NOT NULL,
    `horas_quintal` int NOT NULL,
    `horas_sala` int NOT NULL,
    `icone` varchar(14) NOT NULL,
    `nome` varchar(50) NOT NULL,
    `posicao` int NOT NULL,
    `procentagem_comissao` decimal(19,2) NOT NULL,
    `qtd_horas` int NOT NULL,
    `valor_banheiro` decimal(19,2) NOT NULL,
    `valor_cozinha` decimal(19,2) NOT NULL,
    `valor_minimo` decimal(19,2) NOT NULL,
    `valor_outros` decimal(19,2) NOT NULL,
    `valor_quarto` decimal(19,2) NOT NULL,
    `valor_quintal` decimal(19,2) NOT NULL,
    `valor_sala` decimal(19,2) NOT NULL,
     PRIMARY KEY (`id`)
);