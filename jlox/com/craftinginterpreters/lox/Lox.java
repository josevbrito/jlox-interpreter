package com.craftinginterpreters.lox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Lox {
    // Para indicar se houve algum erro durante a execução para que o programa possa sair com um código de erro apropriado.
    static boolean hadError = false;

    // Função Principal que inicia o programa 
    public static void main(String[] args) throws IOException {
        // Verifica se o número de argumentos da linha de comando é maior que 1.
        if (args.length > 1) {
            System.out.println("Usage: jlox [script]");
            System.exit(64);
        // Se o número de argumentos for 1, ele tenta executar o arquivo especificado.
        } else if (args.length == 1) {
            runFile(args[0]);
        // Caso contrário, se nenhum argumento for fornecido, ele inicia um prompt interativo.
        } else {
            runPrompt();
        }
    }

    // Função que executa um arquivo Lox.
    private static void runFile(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        run(new String(bytes, Charset.defaultCharset()));
        
        if (hadError) System.exit(65);
    }

    
    // Função que executa o código-fonte Lox.
    private static void runPrompt() throws IOException {
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input);

        for (;;) { 
            System.out.print("> ");
            String line = reader.readLine();
            if (line == null) break; 
            run(line);
            hadError = false; 
        }
    }

    // Função que processa o código-fonte Lox.
    private static void run(String source) {
        Scanner scanner = new Scanner(source);
        List<Token> tokens = scanner.scanTokens();

        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    // Função para relatar erros.
    static void error(int line, String message) {
        report(line, "", message);
    }

    // Função para relatar erros específicos.
    private static void report(int line, String where, String message) {
        System.err.println(
            "[line " + line + "] Error" + where + ": " + message);
        hadError = true;
    }
}