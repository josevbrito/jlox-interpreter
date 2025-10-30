package com.craftinginterpreters.lox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.craftinginterpreters.lox.TokenType.*; 

// A classe Scanner é responsável por analisar o código-fonte Lox e produzir uma lista de tokens.
class Scanner {
    // Variáveis 
    private final String source;
    private final List<Token> tokens = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    private int line = 1;

    Scanner(String source) {
        this.source = source;
    }

    List<Token> scanTokens() {
        while (!isAtEnd()) {
            start = current;
            scanToken();
        }

        // Adiciona um token final para marcar o fim do arquivo.
        tokens.add(new Token(EOF, "", null, line));
        return tokens;
    }

    // Verifica se todos os caracteres foram consumidos
    private boolean isAtEnd() {
        return current >= source.length();
    }
    
    // O método principal para reconhecer o próximo token.
    private void scanToken() {
        
    }
}