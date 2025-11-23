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

O interpretador agora está na fase de **Avaliação de Expressões**. Ele lê o código, processa a árvore sintática e **calcula o resultado**.

### Exemplo 1: Aritmética e Precedência

Digite no REPL:

```
> 1 + 2 * 3
```

Saída:

```
7
```

(A multiplicação é executada antes da soma).

### Exemplo 2: Concatenação de Strings

```
> "Lox " + "é " + "legal"
```

Saída:

```
Lox é legal
```

### Exemplo 3: Lógica e Comparação

```
> 5 > 2
```

Saída:

```
true
```

### Exemplo 4: Agrupamento

```
> (1 + 2) * 3
```

Saída:

```
9
```

## 🔍 Funcionalidades Implementadas

### ✅ Scanner (Análise Léxica)

  - Tokenização do código-fonte.
  - Reconhecimento de Literais, Palavras-chave e Identificadores.
  - Suporte a comentários (`//`) e strings multi-linha.

### ✅ Parser (Análise Sintática)

  - Parser de **descida recursiva**.
  - Construção da Árvore Sintática Abstrata (AST).
  - Manipulação correta de **precedência e associatividade**.

### ✅ Interpreter (Avaliação)

  - Implementação do padrão **Visitor** para execução da AST.
  - **Aritmética:** Soma, subtração, multiplicação, divisão.
  - **Lógica:** Comparações (`>`, `<`, `==`) e operadores unários (`!`, `-`).
  - **Tipagem Dinâmica:** Concatenação de strings com `+` e verificação de tipos em tempo de execução.
  - **Truthiness:** Lógica onde apenas `false` e `nil` são falsos.

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
│                   │   ├── Interpreter.java  # Avaliador de expressões
│                   │   ├── RuntimeError.java # Erros de execução
│                   │   └── AstPrinter.java   # Utilitário de debug
│                   └── tool/
│                       └── GenerateAst.java  # Script de geração da AST
├── target/                                   # Pasta de build
├── .gitignore
├── pom.xml                                   # Configuração do Maven
└── README.md
```

## 🐛 Tratamento de Erros

O interpretador lida com três níveis de erros:

1.  **Erros Léxicos:** Caracteres inválidos ou strings não fechadas.
2.  **Erros Sintáticos:** Expressões mal formadas (ex: `1 + * 2`).
3.  **Erros de Tempo de Execução (Runtime):** Operações com tipos inválidos.

Exemplo de erro de execução (tentar somar número com texto):

```
> 5 + "texto"
Operands must be two numbers or two strings.
[line 1]
```

## 📚 Referência

Este projeto é baseado no livro [**Crafting Interpreters**](https://craftinginterpreters.com/) de Robert Nystrom.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.