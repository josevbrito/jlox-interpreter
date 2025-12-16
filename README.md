# Interpretador Lox em Java

Implementação do interpretador para a linguagem Lox, desenvolvido como atividade da disciplina de Compiladores, com base no livro *Crafting Interpreters*.

## Integrantes

- **Nome:** Jose Victor Brito Costa
- **GitHub:** [josevbrito](https://github.com/josevbrito)

- **Nome:** Ana Iara Loayza Costa
- **GitHub:** [iaraloayza](https://github.com/iaraloayza)

## 📋 Pré-requisitos

- **Java JDK 17** ou superior (conforme definido no `pom.xml`)
- **Apache Maven** instalado
- **Git** para clonar o repositório

Para verificar suas versões:
```bash
java -version
mvn -version
````

## 🚀 Como Clonar e Executar

### 1. Clone o repositório

```bash
git clone https://github.com/josevbrito/jlox-interpreter.git
cd jlox-interpreter
```

### 2. Compile o projeto

O projeto é gerenciado pelo Maven. Para compilar o código, rodar testes e criar o pacote `.jar`, execute:

```bash
mvn clean install
```

### 3. Execute o interpretador

#### Modo Interativo (REPL)

Para iniciar o REPL (ideal para testar expressões simples linha por linha.), execute:

```bash
mvn exec:java
```

#### Executar um Arquivo (.lox)

Para executar um script `.lox`, passe o caminho do arquivo como um argumento:

```bash
mvn exec:java -Dexec.args="caminho/do/seu/arquivo.lox"
```

## 📝 Exemplos de Código Lox Incluídos
O repositório já conta com alguns scripts prontos para teste na raiz do projeto:

### 1. Sequência de Fibonacci (`fib.lox`)
Testa laços (`for`) e recursão.

```bash
mvn exec:java -Dexec.args="fib.lox"
```

### 2. Números Primos (`primos.lox`)
Testa lógica matemática e fluxo de controle.

```bash
mvn exec:java -Dexec.args="primos.lox"
```

### 3. Teste de Classes (`conta.lox`)
Demonstra o uso de orientação a objetos em Lox.

```bash
mvn exec:java -Dexec.args="conta.lox"
```

## 🔍 Funcionalidades Implementadas

### ✅ Scanner (Análise Léxica)
* Tokenização completa (símbolos, literais, identificadores, keywords).
* Rastreamento de linhas para reportar erros.

### ✅ Parser (Análise Sintática)
* Parser de descida recursiva (`Recursive Descent`).
* Suporte completo a Expressões e Declarações.
* Tratamento de erros sintáticos (Modo de Pânico).

### ✅ Análise Semântica (Resolver)* Passada de resolução de variáveis antes da interpretação.
* Garante o escopo estático (lexical scoping) correto.
* Detecta erros como `return` fora de funções ou `this` fora de classes.

### ✅ Interpreter (Execução)* **Tipagem Dinâmica:** Verificação em tempo de execução.
* **Controle de Fluxo:** `if/else`, `while`, `for`.
* **Funções:**
* Funções nativas (ex: `clock()`).
* Funções definidas pelo usuário.
* Suporte a `return` e Closures.


* **Orientação a Objetos:**
* Declaração de `class`.
* Instanciação de objetos.
* Métodos e propriedades (`this`).


## 📂 Estrutura do Projeto

```
jlox-interpreter/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── craftinginterpreters/
│                   ├── lox/
│                   │   ├── Lox.java          # Classe principal (Entry point)
│                   │   ├── Scanner.java      # Analisador léxico
│                   │   ├── Parser.java       # Analisador sintático
│                   │   ├── Resolver.java     # Analisador semântico (Scopes)
│                   │   ├── Interpreter.java  # Executor (Visitor)
│                   │   ├── Environment.java  # Gerenciador de escopo/variáveis
│                   │   ├── LoxFunction.java  # Estrutura de funções
│                   │   ├── LoxClass.java     # Estrutura de classes
│                   │   ├── LoxInstance.java  # Instâncias de classes
│                   │   ├── Expr.java         # AST de Expressões
│                   │   ├── Stmt.java         # AST de Declarações
│                   │   └── ... (Token, TokenType, RuntimeError, Return)
│                   └── tool/
│                       └── GenerateAst.java  # Ferramenta geradora de AST
├── target/                                   # Pasta de build
├── conta.lox                                 # Exemplo OO
├── fib.lox                                   # Exemplo Recursão
├── primos.lox                                # Exemplo Lógica
├── pom.xml                                   # Configuração do Maven
└── README.md
```

##📚 Referência

Este projeto é baseado no livro [**Crafting Interpreters**](https://craftinginterpreters.com/) de Robert Nystrom.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.