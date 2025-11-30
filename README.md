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

## 📝 Exemplos de Código Lox

### Exemplo 1: Sequência de Fibonacci (Laços e Variáveis)

Há o arquivo `fib.lox`:

Execute: `mvn exec:java -Dexec.args="fib.lox"`

### Exemplo 2: Condicionais (If/Else)

Crie um arquivo `check.lox`:

```lox
var a = 10;
if (a > 5) {
  print "Maior que 5";
} else {
  print "Menor";
}
```

Execute: `mvn exec:java -Dexec.args="check.lox"`

### Exemplo 3: Escopo e Blocos

Crie um arquivo `scope.lox`:

```lox
var a = "global";
{
  var a = "local";
  print a; // Imprime "local"
}
print a; // Imprime "global"
```

## 🔍 Funcionalidades Implementadas

### ✅ Scanner (Análise Léxica)

  - Tokenização completa (símbolos, literais, identificadores, keywords).

### ✅ Parser (Análise Sintática)

  - Parser de descida recursiva.
  - Suporte a **Expressões** (Aritmética, Lógica, Atribuição).
  - Suporte a **Declarações** (Variáveis `var`, Blocos `{...}`, `if/else`, `while`, `for`, `print`).
  - Tratamento de erros sintáticos com modo de pânico.

### ✅ Interpreter (Execução)

  - Avaliação de expressões e execução de statements.
  - **Gerenciamento de Estado:** Variáveis globais e escopos locais (Environment).
  - **Controle de Fluxo:** Condicionais e laços de repetição.
  - **Tipagem Dinâmica:** Verificação de tipos em tempo de execução.

## 📂 Estrutura do Projeto

```
jlox-interpreter/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── craftinginterpreters/
│                   ├── lox/
│                   │   ├── Lox.java          # Classe principal
│                   │   ├── Scanner.java      # Analisador léxico
│                   │   ├── Parser.java       # Analisador sintático
│                   │   ├── Interpreter.java  # Executor (Visitor)
│                   │   ├── Environment.java  # Gerenciador de variáveis/escopo
│                   │   ├── Expr.java         # AST de Expressões
│                   │   ├── Stmt.java         # AST de Declarações
│                   │   └── ... (Token, TokenType, etc)
│                   └── tool/
│                       └── GenerateAst.java  # Gerador de AST
├── target/                                   # Pasta de build
├── .gitignore
├── fib.lox                                   # Código .lox para teste
├── pom.xml                                   # Configuração do Maven
└── README.md
```

## 📚 Referência

Este projeto é baseado no livro [**Crafting Interpreters**](https://craftinginterpreters.com/) de Robert Nystrom.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.