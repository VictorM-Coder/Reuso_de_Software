# 📌 Exercício CRUD de cursos

Este projeto consiste em um **back-end** desenvolvido com **Spring Boot** e um **front-end** utilizando **Vue.js**.

## 🛠️ Tecnologias Utilizadas
- **Back-end**: Java 21, Spring Boot, Spring Data JPA, H2, Lombok
- **Front-end**: Vue.js 3, Vite, TypeScript, TailwindCSS
- **Banco de Dados**: H2 (ambiente de desenvolvimento)
- **Gerenciador de Dependências**: Maven

---

## 🚀 Como Rodar o Projeto

### 🔹 1. Configurando o Back-end (Spring Boot)
#### 📌 **Pré-requisitos**
Antes de rodar o back-end, certifique-se de ter instalado:
- **Java 21** ([Download](https://jdk.java.net/21/))
- **Maven** ([Instalação](https://maven.apache.org/install.html))
- **Banco de dados** (opcional: H2 ou PostgreSQL)

#### 📌 **Passos para Rodar o Back-end**
1. **Clone o repositório e vá para a pasta do proeto**:
   ```sh
   git clone https://github.com/VictorM-Coder/Reuso_de_Software
   cd curso-crud
   ```
2. **Acesse o diretório do back-end**:
   ```sh
   cd crud-rs
   ```
3. **Configure o banco de dados** (opcional):
   - Estamos usando **H2**, não é necessário configurar nada.

4. **Compile e rode a aplicação**:
   ```sh
   mvn spring-boot:run
   ```
5. **Acesse a API**:
   - A API estará disponível em **http://localhost:8080**

---

### 🔹 2. Configurando o Front-end (Vue.js)
#### 📌 **Pré-requisitos**
Antes de rodar o front-end, instale:
- **Node.js** ([Download](https://nodejs.org/))
- **Gerenciador de Pacotes (npm)**

#### 📌 **Passos para Rodar o Front-end**
1. **Acesse o diretório do front-end**:
   ```sh
   cd curso-crud-front
   ```
2. **Instale as dependências**:
   ```sh
   npm install
   ```

4. **Inicie o servidor de desenvolvimento**:
   ```sh
   npm run dev
   ```

5. **Acesse o front-end**:
   - O front-end estará disponível em **http://localhost:5173**
