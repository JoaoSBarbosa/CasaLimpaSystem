CREATE TABLE `usuario` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `email` varchar(255) NOT NULL,
    `nome` varchar(255) NOT NULL,
    `senha` varchar(255) NOT NULL,
    `sobrenome` varchar(255) DEFAULT NULL,
    `tipo_usuario` varchar(8) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_5171l57faosmj8myawaucatdw` (`email`)
);