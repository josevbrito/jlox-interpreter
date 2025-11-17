# Interpretador Lox em Java

Implementação do interpretador para a linguagem Lox, desenvolvido como atividade da disciplina de Compiladores, com base no livro *Crafting Interpreters*.

## Integrantes

- **Nome:** JOSE VICTOR BRITO COSTA
- **GitHub:** [josevbrito](https://github.com/josevbrito)

- **Nome:** ANA IARA LOAYZA COSTA
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

### Exemplo 1: Hello World

Crie um arquivo `hello.lox`:

```lox
print "Hello, World!";
```

Execute:

```bash
mvn exec:java -Dexec.args="hello.lox"
```

(O interpretador ainda está na fase de *Análise Léxica* e *AST*, então ele irá imprimir os tokens ou a árvore, não executar o código).

### Exemplo 2: Variáveis e Operações Aritméticas

Crie um arquivo `variaveis.lox`:

```lox
var a = 10;
var b = 20;
var soma = a + b;
print soma;
```

### Exemplo 3: Modo Interativo

Execute o interpretador sem argumentos:

```bash
mvn exec:java
```

Depois digite comandos interativamente:

```
> var x = 10;
> print "Olá, Lox!";
```

(O programa irá ler a linha, gerar os tokens e aguardar a próxima entrada).

Para sair do modo interativo, pressione `Ctrl+C` ou `Ctrl+D`.

## 🔍 Funcionalidades Implementadas

### ✅ Scanner (Análise Léxica)

  - Tokenização do código-fonte
  - Tokens de um caractere: `( ) { } , . - + ; * /`
  - Tokens de dois caracteres: `!= == <= >= ! =`
  - Literais: Números (inteiros e decimais), Strings
  - Identificadores: Variáveis e nomes personalizados
  - Palavras-chave: `and`, `class`, `else`, `false`, `for`, `fun`, `if`, `nil`, `or`, `print`, `return`, `super`, `this`, `true`, `var`, `while`
  - Comentários: Comentários de linha única com `//`
  - Strings multilinha: Suporte para strings que abrangem várias linhas
  - Modo REPL: Interpretador interativo que imprime tokens

### ✅ Representação da AST (Árvore Sintática Abstrata)

  - Geração automática das classes de Expressão (`Expr.java`) usando um script em `tool/`.
  - Implementação do **Padrão Visitor** para permitir operações na árvore (ex: impressão).
  - Utilitário `AstPrinter` (implementando o Visitor) para visualização e depuração da AST em formato Lisp (ex: `(* (- 123) (group 45.67))`).

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
│                   │   └── AstPrinter.java   # Impressora da AST
│                   └── tool/
│                       └── GenerateAst.java
├── target/                     # Pasta de build (ignorada pelo Git)
├── .gitignore
├── pom.xml                     # Configuração do Maven
└── README.md
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