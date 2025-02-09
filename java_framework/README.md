# Framework Simples de Gerenciamento de Entidades em Java

## Descrição
Este é um framework simples em Java para gerenciar entidades genéricas, permitindo realizar operações básicas de CRUD (Create, Read, Update, Delete). O projeto utiliza conceitos de Generics, Programacão Orientada a Objetos (POO) e boas práticas de design para criar uma solução reutilizável.

## Estrutura do Projeto

```
src/
└── org/
    └── example/
        ├── entities/
        │   ├── Produto.java
        │   └── Cliente.java
        ├── repositories/
        │   ├── CrudRepository.java
        │   ├── InMemoryRepository.java
        │   └── InFileRepository.java
        └── Main.java
```

## Funcionalidades
- **CRUD Genérico**: Permite criar, ler, atualizar e deletar qualquer tipo de entidade.
- **Duas Implementações de Repositório**:
  - `InMemoryRepository<T>`: Armazena os dados em memória usando um `HashMap`.
  - `InFileRepository<T>`: Persiste os dados em arquivos JSON usando a biblioteca Jackson.
- **Entidades de Teste**:
  - `Produto` com atributos `nome` e `preco`.
  - `Cliente` com atributos `nome` e `email`.

## Como Compilar e Executar

1. **Compilar o projeto:**
```bash
mvn clean compile assembly:single
```

2. **Executar o programa:**
```bash
java -jar .\target\java_framework-1.0-SNAPSHOT-jar-with-dependencies.jar
```

## Exemplo de Saída
```
========== TESTANDO PRODUTOS ==========

--- InMemoryRepository ---
Produtos cadastrados:
Produto{nome='Laptop', preco=3000.0}
Produto{nome='Mouse', preco=50.0}

Produto atualizado:
Produto{nome='Mouse Gamer', preco=150.0}

Produtos após deletar o Laptop:
Produto{nome='Mouse Gamer', preco=150.0}

--- InFileRepository ---
Produtos salvos no arquivo:
Produto{nome='Laptop', preco=3000.0}
Produto{nome='Mouse', preco=50.0}

Produto atualizado no arquivo:
Produto{nome='Mouse Gamer', preco=150.0}

Produtos após deletar o Laptop do arquivo:
Produto{nome='Mouse Gamer', preco=150.0}

========== TESTANDO CLIENTES ==========

--- InMemoryRepository ---
Clientes cadastrados:
Cliente{nome='João', email='joao@example.com'}
Cliente{nome='Maria', email='maria@example.com'}

Cliente atualizado:
Cliente{nome='Maria Clara', email='maria.clara@example.com'}

Clientes após deletar João:
Cliente{nome='Maria Clara', email='maria.clara@example.com'}

--- InFileRepository ---
Clientes salvos no arquivo:
Cliente{nome='João', email='joao@example.com'}
Cliente{nome='Maria', email='maria@example.com'}

Cliente atualizado no arquivo:
Cliente{nome='Maria Clara', email='maria.clara@example.com'}

Clientes após deletar João do arquivo:
Cliente{nome='Maria Clara', email='maria.clara@example.com'}
```

## Requisitos
- Java 21
- Windows 11 (não testado em outros SOs)

## Artefatos
- [.jar](target/java_framework-1.0-SNAPSHOT-jar-with-dependencies.jar)
- [PDF com exemplo](execucao.pdf)


