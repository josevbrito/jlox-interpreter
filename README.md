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

Isso irá baixar as dependências e compilar todo o código-fonte na pasta `target/`.

### 3. Execute o interpretador

Nós configuramos o `pom.xml` para facilitar a execução usando o plugin `exec-maven-plugin`.

#### Modo Interativo (REPL)

Para iniciar o REPL, execute:

```bash
mvn exec:java
```

#### Executar um arquivo

Para executar um script `.lox`, passe o caminho do arquivo como um argumento:

```bash
mvn exec:java -Dexec.args="caminho/do/seu/arquivo.lox"
```

## 📝 Exemplos de Código Lox

O interpretador agora está na fase de **Análise Sintática**. Ele irá ler o código, construir a Árvore Sintática Abstrata (AST) e imprimi-la no console.

### Exemplo 1: Precedência de Operadores

Digite no REPL:

```
> 1 + 2 * 3;
```

Saída (AST no formato Lisp):

```
(+ 1.0 (* 2.0 3.0))
```

Isso demonstra que o parser entende que a multiplicação (`*`) deve ser executada antes da adição (`+`).

### Exemplo 2: Agrupamento

Digite no REPL:

```
> (1 + 2) * 3;
```

Saída:

```
(* (group (+ 1.0 2.0)) 3.0)
```

Isso mostra que os parênteses têm a maior precedência.

### Exemplo 3: Operadores Lógicos e Comparação

```
> 1 < 2 == true;
```

Saída:

```
(== (< 1.0 2.0) true)
```

### Exemplo 4: Modo Interativo

Execute o interpretador sem argumentos:

```bash
mvn exec:java
```

Depois digite comandos interativamente:

```
> 5 * (10 - 2);
(* 5.0 (group (- 10.0 2.0)))
```

Para sair do modo interativo, pressione `Ctrl+C` ou `Ctrl+D`.

## 🔍 Funcionalidades Implementadas

### ✅ Scanner (Análise Léxica)

  - Tokenização do código-fonte.
  - Reconhecimento de tokens de um ou dois caracteres (`(`, `!=`, etc.).
  - Reconhecimento de Literais (Números, Strings), Palavras-chave e Identificadores.
  - Suporte a comentários (`//`) e strings multi-linha.
  - Modo REPL interativo.

### ✅ Representação da AST (Árvore Sintática Abstrata)

  - Geração automática das classes de Expressão (`Expr.java`) usando um script.
  - Implementação do **Padrão Visitor** para permitir operações na árvore.
  - Utilitário `AstPrinter` (implementando o Visitor) para visualização da AST.

### ✅ Parser (Análise Sintática)

  - Implementação de um parser de **descida recursiva**.
  - Conversão da sequência de tokens em uma Árvore Sintática Abstrata (AST).
  - Manipulação correta de **precedência e associatividade** de operadores.
  - Suporte para todas as expressões da gramática: Literais, Agrupamento (`()`), Unárias (`-`, `!`) e Binárias (`+`, `-`, `*`, `/`, `==`, `!=`, `<`, `<=`, `>`, `>=`).

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
│                   │   ├── Token.java        # Representação de tokens
│                   │   ├── TokenType.java    # Tipos de tokens
│                   │   ├── Expr.java         # Classes da AST (geradas)
│                   │   ├── Parser.java       # Analisador sintático
│                   │   └── AstPrinter.java   # Impressora da AST
│                   └── tool/
│                       └── GenerateAst.java  # Script de geração da AST
├── target/                                   # Pasta de build
├── .gitignore
├── pom.xml                                   # Configuração do Maven
└── README.md
```

## 🐛 Tratamento de Erros

O interpretador detecta e reporta dois tipos de erros:

1.  **Erros Léxicos** (do Scanner):
      - Strings não terminadas
      - Caracteres inesperados
2.  **Erros Sintáticos** (do Parser):
      - Expressões mal formadas (ex: `1 + * 2`)
      - Parênteses não fechados (ex: `(1 + 2`)

Exemplo de saída de erro:

```
> 1 + * 3;
[line 1] Error at '*': Expect expression.
```

## 📚 Referência

Este projeto é baseado no livro [**Crafting Interpreters**](https://craftinginterpreters.com/) de Robert Nystrom.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.