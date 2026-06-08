# Farmácia API 💊
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.5-brightgreen?style=for-the-badge&logo=springboot)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue?style=for-the-badge&logo=mysql)
![Spring Security](https://img.shields.io/badge/Spring%20Security-JWT-darkgreen?style=for-the-badge&logo=springsecurity)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger)
![Git](https://img.shields.io/badge/Git-Versionamento-red?style=for-the-badge&logo=git)
![GitHub](https://img.shields.io/badge/GitHub-Repositório-black?style=for-the-badge&logo=github)
![Status](https://img.shields.io/badge/Status-Concluído-success?style=for-the-badge)

API REST desenvolvida em Spring Boot para gerenciamento de uma farmácia, com CRUD completo de Categorias e Produtos, cadastro e autenticação de Usuários com JWT.

Projeto individual — Performance Goal Check Bloco 02 | Generation Brasil

---

## Objetivo do projeto

O objetivo deste projeto é praticar os principais conceitos de desenvolvimento backend com Spring Boot, como:

- Criação de API REST com Spring Web
- Mapeamento de entidades com Spring Data JPA
- Relacionamento entre entidades (`@ManyToOne` / `@OneToMany`)
- Validação de dados com Bean Validation
- Autenticação e autorização com Spring Security e JWT
- Documentação de API com Springdoc OpenAPI / Swagger UI
- Boas práticas de versionamento com Git e GitHub

---

## Funcionalidades

- Cadastrar, listar, buscar, atualizar e deletar categorias
- Cadastrar, listar, buscar, atualizar e deletar produtos
- Relacionar produtos a categorias com integridade referencial
- Cadastrar, autenticar e gerenciar usuários
- Proteger endpoints com token JWT
- Documentar e testar a API via Swagger UI

---

## Estrutura do projeto

```text
src/main/java/com/generation/farmacia
├── controller
│   ├── CategoriaController.java
│   ├── ProdutoController.java
│   └── UsuarioController.java
├── model
│   ├── Categoria.java
│   ├── Produto.java
│   └── Usuario.java
├── repository
│   ├── CategoriaRepository.java
│   ├── ProdutoRepository.java
│   └── UsuarioRepository.java
├── security
│   ├── JwtAuthFilter.java
│   ├── JwtService.java
│   ├── SecurityConfig.java
│   ├── UserDetailsImpl.java
│   └── UserDetailsServiceImpl.java
└── ProjetoFinalBloco02Application.java
```

---

## Endpoints

### Usuários

| Método | Endpoint | Autenticação | Descrição |
|--------|----------|-------------|-----------|
| POST | /usuarios/cadastrar | Pública | Cadastra novo usuário |
| POST | /usuarios/logar | Pública | Autentica e retorna token JWT |
| GET | /usuarios | Token JWT | Lista todos os usuários |
| GET | /usuarios/{id} | Token JWT | Busca usuário por id |
| PUT | /usuarios/{id} | Token JWT | Atualiza usuário |

### Categorias

| Método | Endpoint | Autenticação | Descrição |
|--------|----------|-------------|-----------|
| GET | /categorias | Token JWT | Lista todas as categorias |
| GET | /categorias/{id} | Token JWT | Busca categoria por id |
| GET | /categorias/nome/{nome} | Token JWT | Busca categoria por nome |
| POST | /categorias | Token JWT | Cadastra nova categoria |
| PUT | /categorias | Token JWT | Atualiza categoria |
| DELETE | /categorias/{id} | Token JWT | Deleta categoria |

### Produtos

| Método | Endpoint | Autenticação | Descrição |
|--------|----------|-------------|-----------|
| GET | /produtos | Token JWT | Lista todos os produtos |
| GET | /produtos/{id} | Token JWT | Busca produto por id |
| GET | /produtos/nome/{nome} | Token JWT | Busca produto por nome |
| POST | /produtos | Token JWT | Cadastra novo produto |
| PUT | /produtos | Token JWT | Atualiza produto |
| DELETE | /produtos/{id} | Token JWT | Deleta produto |

---

## Autenticação

A API utiliza JWT Bearer Token. Após o login em `/usuarios/logar`, inclua o token retornado no header de todas as requisições protegidas:
