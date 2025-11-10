# Interpretador Lox em Java

Implementação do interpretador para a linguagem Lox, desenvolvido como atividade da disciplina de Compiladores, com base no livro *Crafting Interpreters*.

## Integrantes

- **Nome:** JOSE VICTOR BRITO COSTA
- **GitHub:** [josevbrito](https://github.com/josevbrito)

- **Nome:** ANA IARA LOAYZA COSTA
- **GitHub:** [iaraloayza](https://github.com/iaraloayza)

## 📋 Pré-requisitos

- **Java JDK 8** ou superior instalado
- **Git** para clonar o repositório

Para verificar se o Java está instalado:
```bash
java -version
javac -version
```

## 🚀 Como Clonar e Executar

### 1. Clone o repositório

```bash
git clone https://github.com/josevbrito/jlox-interpreter.git
cd jlox-interpreter
```

### 2. Compile o projeto

Execute este comando na raiz do projeto, `jlox-interpreter/`

```bash
javac com/craftinginterpreters/lox/*.java
```

### 3. Execute o interpretador

#### Modo Interativo (REPL)
```bash
java com.craftinginterpreters.lox.Lox
```

#### Executar um arquivo
```bash
java com.craftinginterpreters.lox.Lox caminho/do/arquivo.lox
```

## 📝 Exemplos de Código Lox

### Exemplo 1: Hello World
Crie um arquivo `hello.lox`:
```lox
print "Hello, World!";
```

Execute:
```bash
java com.craftinginterpreters.lox.Lox hello.lox
```

### Exemplo 2: Variáveis e Operações Aritméticas
Crie um arquivo `variaveis.lox`:
```lox
var a = 10;
var b = 20;
var soma = a + b;
print soma;
```

### Exemplo 3: Strings
```lox
var nome = "Lox";
var mensagem = "Bem-vindo ao " + nome + "!";
print mensagem;
```

### Exemplo 4: Expressões Lógicas
```lox
var x = 5;
var y = 10;
print x == y;
print x != y;
print x < y;
print x >= y;
```

### Exemplo 5: Comentários
```lox
// Este é um comentário de linha única
var numero = 42; // comentário no final da linha
print numero;
```

### Exemplo 6: Números Decimais
```lox
var pi = 3.14159;
var raio = 5;
var area = pi * raio * raio;
print area;
```

### Exemplo 7: Valores Booleanos
```lox
var verdadeiro = true;
var falso = false;
print verdadeiro;
print falso;
```

### Exemplo 8: Operadores Lógicos
```lox
print true and false;
print true or false;
print !true;
```

### Exemplo 9: Modo Interativo
Execute o interpretador sem argumentos:
```bash
java com.craftinginterpreters.lox.Lox
```

Depois digite comandos interativamente:
```
> var x = 10;
> var y = 20;
> print x + y;
30
> print "Olá, Lox!";
Olá, Lox!
```

Para sair do modo interativo, pressione `Ctrl+C` ou `Ctrl+D`.

## 🔍 Funcionalidades Implementadas

### ✅ **Scanner (Análise Léxica)**
  - **Tokenização do código-fonte**
  - **Tokens de um caractere**: `( ) { } , . - + ; * /`
  - **Tokens de dois caracteres**: `!= == <= >= ! =`
  - **Literais**: Números (inteiros e decimais), Strings
  - **Identificadores**: Variáveis e nomes personalizados
  - **Palavras-chave**: `and`, `class`, `else`, `false`, `for`, `fun`, `if`, `nil`, `or`, `print`, `return`, `super`, `this`, `true`, `var`, `while`
  - **Comentários**: Comentários de linha única com `//`
  - **Strings multilinha**: Suporte para strings que abrangem várias linhas
  - **Modo REPL**: Interpretador interativo que imprime tokens

### ✅ Representação da AST (Árvore Sintática Abstrata)

  - Geração automática das classes de Expressão (`Expr.java`) usando um script em `tool/`.
  - Implementação do **Padrão Visitor** para permitir operações na árvore (ex: impressão).
  - Utilitário `AstPrinter` (implementando o Visitor) para visualização e depuração da AST em formato Lisp (ex: `(* (- 123) (group 45.67))`).

## 📂 Estrutura do Projeto

```
jlox-interpreter/
└── com/
    └── craftinginterpreters/
        ├── lox/
        │   ├── Lox.java          # Classe principal
        │   ├── Scanner.java      # Analisador léxico
        │   ├── Token.java        # Representação de tokens
        │   ├── TokenType.java    # Tipos de tokens
        │   ├── Expr.java         # Classes da AST (geradas)
        │   └── AstPrinter.java   # Impressora da AST
        └── tool/
            └── GenerateAst.java  # Script de geração da AST
```

## 🐛 Tratamento de Erros

O interpretador detecta e reporta erros léxicos, como:
  - Strings não terminadas
  - Caracteres inesperados

Exemplo de saída de erro:
```
[line 2] Error: String não terminada.
[line 5] Error: Caractere Inesperado.
```

## 📚 Referência

Este projeto é baseado no livro [**Crafting Interpreters**](https://craftinginterpreters.com/) de Robert Nystrom.

## 📄 Licença

Este projeto é de código aberto e está disponível para fins educacionais.