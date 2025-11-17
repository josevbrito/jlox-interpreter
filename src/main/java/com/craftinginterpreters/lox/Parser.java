package com.craftinginterpreters.lox;

import java.util.List;
import static com.craftinginterpreters.lox.TokenType.*;

class Parser {
    private final List<Token> tokens;
    private int current = 0;

    Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    /*
     * MÉTODOS AUXILIARES (INFRAESTRUTURA)
     */

    /**
     * Verifica se o token atual é de algum dos tipos esperados.
     * Se for, consome o token e retorna true.
     */
    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (check(type)) {
                advance();
                return true;
            }
        }
        return false;
    }

    /**
     * Verifica se o token atual é do tipo esperado, mas não o consome.
     */
    private boolean check(TokenType type) {
        if (isAtEnd()) return false;
        return peek().type == type;
    }

    /**
     * Consome o token atual e avança o ponteiro 'current'.
     */
    private Token advance() {
        if (!isAtEnd()) current++;
        return previous();
    }

    /**
     * Verifica se estamos no final da lista de tokens.
     */
    private boolean isAtEnd() {
        return peek().type == EOF;
    }

    /**
     * Retorna o token atual sem consumi-lo.
     */
    private Token peek() {
        return tokens.get(current);
    }

    /**
     * Retorna o token que acabamos de consumir.
     */
    private Token previous() {
        return tokens.get(current - 1);
    }
}