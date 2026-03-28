# Spring Job Management API (Gestão de Vagas)

> **⚠️ Em Desenvolvimento (Work in Progress)**
>
> Este projeto está sendo desenvolvido à medida que avanço na trilha de estudos de Java da Rocketseat. Novas *features* (como a implementação completa dos módulos de `Company` e `Job`) e refatorações serão adicionadas.

API RESTful para gestão de vagas, desenvolvida como parte da trilha de estudos em Java da Rocketseat. O projeto foca em boas práticas de arquitetura de software, segurança e ambiente de desenvolvimento com Spring Boot e Docker.

## 🚀 Features

* **Arquitetura Modular:** Separação clara de responsabilidades por módulos (`candidate`, `company`).
* **Casos de Uso (Use Cases):** Lógica de negócio abstraída em classes de serviço (Use Cases), mantendo os `Controllers` limpos e focados no roteamento.
* **Tratamento de Exceções Global:** Um `ExceptionHandlerController` centralizado captura exceções de negócio e validação, retornando mensagens de erro padronizadas.
* **Validação:** Uso do `Spring Validation` (Bean Validation) para garantir a integridade dos dados de entrada.
* **Segurança de Credenciais:** Nenhuma senha ou dado sensível está "hardcoded". O projeto utiliza Variáveis de Ambiente para carregar as credenciais do banco de dados.

## 🛠️ Tecnologias Utilizadas

* **Backend:** Java 21, Spring Boot 3, Spring Data JPA, Spring Web, Spring Validation
* **Banco de Dados:** PostgreSQL
* **Ambiente:** Docker (via `docker-compose.yml`)
* **Build/Dependências:** Maven
* **Utilitários:** Lombok

## 🏁 Como Rodar o Projeto

### Pré-requisitos

* Java 17 (ou superior)
* Maven
* Docker e Docker Compose

---
### 1. Clone o Repositório

```bash
git clone https://github.com/Leturnos/spring-job-management-api.git
cd spring-job-management-api
```

### 2. Configure as Variáveis de Ambiente

```bash
cp env.example .env
# Edite o arquivo .env com suas configurações
```

Você precisa definir as seguintes variáveis de ambiente no seu sistema ou na configuração de execução da sua IDE (IntelliJ, VSCode, etc.):

* DB_USERNAME: O usuário do seu banco PostgreSQL (ex: admin)

* DB_PASSWORD: A senha do seu banco PostgreSQL (ex: admin)

### 3. Suba o Banco de Dados (Docker)
O docker-compose.yml irá ler as variáveis de ambiente (DB_USERNAME, DB_PASSWORD) e configurar o contêiner do Postgres automaticamente.

```bash
docker-compose up -d
```

### 4. Execute a Aplicação Spring
Certifique-se de que as variáveis de ambiente do Passo 2 estão configuradas na sua IDE ou terminal antes de rodar.

```bash
mvn spring-boot:run
```
A API estará disponível em http://localhost:8080.

## 📖 API Endpoints
Módulo: Candidate

POST /candidate/

Cria um novo candidato. O sistema valida se username ou email já existem no banco.

Exemplo de Body (Sucesso):

```JSON
{
    "name": "Leandro",
    "username": "leandro",
    "email": "emailteste@gmail.com",
    "password": "pequenasenha123",
    "description": "Estudante",
    "curriculum": "Estou gostando do JAVA"
}
```
Retorno (201 CREATED):

```JSON
{
    "id": "63d476b1-a748-482b-9c26-a995d2654381",
    "name": "Leandro",
    "username": "leandro",
    "email": "emailteste@gmail.com",
    "password": "pequenasenha123",
    "description": "Estudante",
    "curriculum": "Estou gostando do JAVA",
    "createdAt": "2025-10-26T21:02:45.16264"
}
```
Exemplo de Retorno (Erro de Validação 400):

```JSON
[
    {
        "message": "O comprimento deve ser entre 8 e 100",
        "field": "password"
    },
    {
        "message": "O campo username nao deve conter espaços",
        "field": "username"
    }
]
```
Exemplo de Retorno (Regra de Negócio 400):

```JSON
{
  "message": "Usuário já existe"
}
```

## ⚖️ Licença
Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
