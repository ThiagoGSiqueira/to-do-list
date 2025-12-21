# ✍️ Task Manager Console Application

Este é um projeto de estudo em Java focado no gerenciamento de tarefas (CRUD).

O objetivo principal é criar uma aplicação de linha de comando robusta, aplicando princípios de design moderno.

## 🎯 Objetivo Arquitetural

A arquitetura do projeto é construída com foco em:
* 🧩 **Desacoplamento:** Separação clara de responsabilidades entre as camadas (Controller, Handler, Service, DAO).
* 🧪 **Testabilidade:** Uso de Injeção de Dependência (DI) via `ApplicationFactory` para isolar componentes.
* 🗄️ **Persistência:** Utilização de JDBC puro para conexão com MySQL.

---

## 📥 Instalação

1. Clone o repositório em sua máquina local:
   ```bash
   git clone [https://github.com/ThiagoGSiqueira/to-do-list.git](https://github.com/ThiagoGSiqueira/to-do-list.git)

---

## 🛠️ Como Executar

### 📋 Pré-requisitos
* ☕ **Java JDK 21** ou superior.
* 💻 **IDE** de sua preferência (IntelliJ IDEA, VS Code, Eclipse).
* 🔌 **MySQL ConnectorJ** (Caso queira utilizar o banco de dados real).

### 🗄️ Opção 1: Execução com MySQL
* 📜 Crie o banco de dados usando o script localizado em `src/app/database/sql`.
* 📦 Adicione o arquivo `.jar` do MySQL connector às bibliotecas do seu projeto na IDE.
* 🔑 Em `resources/db` altere o nome do arquivo `db.properties.example` para `db.properties`.
* ✍️ Insira suas credenciais do banco de dados.
* ▶️ Execute a classe `Main.java`.

### 🃏 Opção 2: Execução em Modo Mock (Sem banco de dados)
* ✨ Graças à arquitetura desacoplada (Inversão de dependência), você pode rodar o sistema sem precisar instalar o MySQL.
* ▶️ Execute a classe `TestRunner`.
