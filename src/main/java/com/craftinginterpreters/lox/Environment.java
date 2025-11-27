package com.craftinginterpreters.lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
    private final Map<String, Object> values = new HashMap<>();

    // Define uma nova variável (ou atualiza uma existente)
    void define(String name, Object value) {
        values.put(name, value);
    }

    // Busca o valor de uma variável pelo nome
    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        // Se não encontrar, lança um erro de tempo de execução
        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }
}