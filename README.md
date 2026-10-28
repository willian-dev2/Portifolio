# Portfólio API

API REST que fornece todo o conteúdo do meu portfólio: perfil, tecnologias, formação, experiências e projetos. Nenhum dado fica fixo no front-end: tudo vem do banco de dados.

As rotas de leitura são públicas. As de cadastro, edição e remoção são restritas a um administrador autenticado com JWT.

## Tecnologias

- **Java 17** e **Spring Boot 4**
- **Spring Security** + **JWT** (jjwt) para autenticação
- **Spring Data JPA** + **PostgreSQL**
- **MapStruct** para conversão entre entidades e DTOs
- **Lombok**
- **Docker** e **Docker Compose**

## Funcionalidades

- Leitura pública de perfil, tecnologias, formação, experiências e projetos
- Painel administrativo protegido por JWT (cadastrar, atualizar e remover itens)
- **Atualização parcial:** no `PUT`, só os campos enviados são alterados
- Projetos e experiências ligados às tecnologias usadas (relacionamento muitos-para-muitos)
- Cadastro de administrador travado por um código de configuração e bloqueado depois do primeiro registro
- Tratamento global de exceções com respostas de erro padronizadas
- CORS configurado por variável de ambiente

## Arquitetura

Monólito organizado em camadas:

```
src/main/java/dev/java/curriVitae
├── controller/        → endpoints REST (público e admin)
├── business/
│   ├── dto/           → objetos de entrada e saída da API
│   ├── mapper/        → conversores MapStruct
│   └── service/       → regras de negócio
└── infrastructure/
    ├── entity/        → entidades JPA
    ├── enums/
    ├── exception/     → exceções e handler global
    ├── repository/    → Spring Data JPA
    └── security/      → JWT, filtro de autenticação e configuração do Spring Security
```

## Como rodar

### Pré-requisitos

- Java 17+
- Docker

### 1. Variáveis de ambiente

Crie um arquivo `.env` na raiz do projeto (ele está no `.gitignore` e não vai para o repositório):

```properties
DB_NAME=portfolio
DB_USER=postgres
DB_PASSWORD=sua_senha
JWT_SECRET=uma_chave_aleatoria_com_pelo_menos_32_caracteres
ADMIN_SETUP_TOKEN=codigo_para_cadastrar_o_admin
APP_CORS_ORIGENS=http://localhost:5173
```

| Variável | Para que serve |
|---|---|
| `DB_NAME`, `DB_USER`, `DB_PASSWORD` | Conexão com o PostgreSQL |
| `JWT_SECRET` | Chave que assina os tokens (mínimo de 32 caracteres) |
| `ADMIN_SETUP_TOKEN` | Código exigido para cadastrar o primeiro administrador |
| `APP_CORS_ORIGENS` | Endereços do front-end autorizados a chamar a API |

Para gerar uma chave aleatória: `openssl rand -base64 48`

### 2. Subir o banco

```bash
docker compose up -d db
```

### 3. Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:9090`.

Para rodar a aplicação também dentro do Docker:

```bash
docker compose --profile full up -d --build
```

## Autenticação

1. Cadastre o administrador (funciona uma única vez):

```http
POST /api/auth/registrarAdmin
Content-Type: application/json

{
  "nome": "Seu nome",
  "email": "admin@exemplo.com",
  "senha": "senha_com_8_ou_mais_caracteres",
  "codigoSetup": "valor_do_ADMIN_SETUP_TOKEN"
}
```

2. Faça login e copie o token da resposta:

```http
POST /api/login
Content-Type: application/json

{ "email": "admin@exemplo.com", "senha": "..." }
```

3. Envie o token nas rotas administrativas:

```
Authorization: Bearer <token>
```

O token expira em 1 hora.

## Endpoints

### Públicos

| Método | Rota | Descrição |
|---|---|---|
| GET | `/api/perfil` | Dados do perfil e contatos |
| GET | `/api/tecnologias` | Lista de tecnologias |
| GET | `/api/formacao` | Lista de formações |
| GET | `/api/experiencia` | Lista de experiências |
| GET | `/api/projetos` | Lista de projetos |
| GET | `/api/buscar-{recurso}/{id}` | Um item pelo id (`perfil`, `tecnologias`, `formacao`, `experiencia`, `projetos`) |
| POST | `/api/login` | Login do administrador |
| POST | `/api/auth/registrarAdmin` | Cadastro do primeiro administrador |

### Administrativos (exigem token)

| Método | Rota | Descrição |
|---|---|---|
| POST | `/api/admin/registrar/{recurso}` | Cadastra um item |
| PUT | `/api/admin/atualizar/{recurso}/{id}` | Atualiza parcialmente um item |
| DELETE | `/api/admin/delete/{recurso}/{id}` | Remove um item |

`{recurso}` = `perfil`, `tecnologias`, `formacao`, `experiencia` ou `projetos`.

Ao cadastrar experiências e projetos, as tecnologias são informadas pelo id:

```json
"tecnologias": [ { "id": 1 }, { "id": 2 } ]
```

### Respostas de erro

Todos os erros seguem o mesmo formato:

```json
{ "error": "Projeto não encontrado" }
```

| Status | Quando |
|---|---|
| 401 | E-mail ou senha inválidos |
| 403 | Token ausente, inválido ou expirado |
| 404 | Item não encontrado |
| 409 | Tentativa de remover um item que está em uso |
| 500 | Erro interno |

## Autor

**Willian Vinicius Sousa do Nascimento**

- GitHub: [willian-dev2](https://github.com/willian-dev2)
- LinkedIn: [willian-vinicius](https://linkedin.com/in/willian-vinicius-3128b7363)
