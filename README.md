# Casa Limpa Plus 🧹

**Casa Limpa Plus** é uma aplicação desenvolvida em Java com Spring Boot que facilita a busca e contratação de diaristas confiáveis, com avaliações de usuários. A aplicação permite gerenciamento de serviços e é integrada com uma interface amigável usando Thymeleaf e AdminLTE.

## Índice

- [Descrição](#descrição)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Instalação](#instalação)
- [Uso](#uso)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Licença](#licença)

## Descrição

O **Casa Limpa Plus** foi criado para conectar clientes a diaristas de forma rápida e segura. A aplicação permite cadastrar, editar e excluir serviços, além de exibir uma lista de profissionais com avaliações de clientes, tudo em um ambiente administrável.

## Funcionalidades

- Cadastro e gestão de serviços
- Listagem de serviços disponíveis
- Avaliações de usuários para diaristas
- Gerenciamento de usuários (em breve)
- Sistema de autenticação e autorização (em breve)

## Tecnologias

| Tecnologia                                                                                                        | Versão               |
| ----------------------------------------------------------------------------------------------------------------- | -------------------- |
| ![Java](https://img.shields.io/badge/Java-17-007396?style=for-the-badge&logo=java&logoColor=white)                | Java 17              |
| ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.5.4-brightgreen?style=for-the-badge&logo=spring-boot) | Spring Boot 2.5.4    |
| ![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0.11-blue?style=for-the-badge&logo=thymeleaf)               | Thymeleaf            |
| ![JPA](https://img.shields.io/badge/JPA-Hibernate-lightgrey?style=for-the-badge&logo=hibernate)                   | JPA/Hibernate        |
| ![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql&logoColor=white)              | MySQL                |
| ![H2 Database](https://img.shields.io/badge/H2%20Database-1.4.200-lightgrey?style=for-the-badge&logo=h2)          | Banco de Dados H2    |
| ![Lombok](https://img.shields.io/badge/Lombok-1.18.20-green?style=for-the-badge&logo=lombok)                      | Lombok               |
| ![AdminLTE](https://img.shields.io/badge/AdminLTE-3.2.0-blueviolet?style=for-the-badge&logo=bootstrap)            | AdminLTE             |
| ![WebJars](https://img.shields.io/badge/WebJars-Locator-yellow?style=for-the-badge)                               | WebJars Locator Core |
| ![Validação](https://img.shields.io/badge/Validação-Jakarta-orange?style=for-the-badge&logo=java)                 | Validação            |

## Instalação

1. **Pré-requisitos**: Certifique-se de que você tem o [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) e [Maven](https://maven.apache.org/) instalados.

2. **Clone o repositório**:

   ```bash
   git clone https://github.com/seu-usuario/casaLimpaPlus.git
   cd casaLimpaPlus
   ```

3. **Configuração do Banco de Dados**:

   - Configure o banco de dados no arquivo `application.properties` ou `application.yml`.

4. **Executar o Projeto**:

   ```bash
   mvn spring-boot:run
   ```

## Uso

1. Acesse a aplicação no navegador em `http://localhost:8080/admin/servicos`.
2. Para gerenciar serviços, navegue até a seção de administração:
   - Listar serviços: `/admin/servicos`
   - Cadastrar um novo serviço: `/admin/servicos/cadastrar`
   - Editar um serviço existente: `/admin/servicos/{id}/editar`
   - Excluir um serviço: `/admin/servicos/{id}/excluir`

## Estrutura do Projeto

```plaintext
src
├── main
│   ├── java
│   │   └── com
│   │       └── joaosbarbosa
│   │           └── dev
│   │               └── casaLimpaPlus
│   │                   ├── api
│   │                   ├── core
│   │                       ├── component
│   │                       ├── exceptions
│   │                       │   └── EntityNotFoundExceptionCustomer.java
│   │                       ├── models
│   │                           ├── enums
│   │                           │   └── Icone.java
│   │                       │   └── Servico.java                # Entidade Servico
│   │                       ├── repository
│   │                       │   └── ServicoRepository.java      # Interface para acesso a dados de serviços
│   │                   ├── web
│   │                       ├── controller
│   │                       │   └── ServicoController.java      # Controller para manipulação de serviços
│   │                       ├── dto
│   │                       │   └── FlashMessageDTO.java        # DTO para envio de alerta
│   │                       │   └── ServicoFormDTO.java         # DTO para formulário de serviço
│   │                   ├── mappers
│   │                   │   └── WebServicoMapper.java           # Classe para conversão entre DTO e MODEL
│   │                   └── service
│   │                       └── WebServicoService.java         # Serviço para lógica de negócios
│   └── resources
│       ├── static
│       │   └── img
│       │       └── logo.png
│       │       └── user.jpg
│       ├── templates
│       │   └── admin
│       │       └── servico
│       │           ├── lista.html                         # Lista de serviços
│       │           └── form.html                          # Formulário de serviço
│       └── application.properties                        # Configurações de aplicação
```

## Licença

Este projeto é distribuído sob a licença MIT.
