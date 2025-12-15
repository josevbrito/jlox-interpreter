package com.craftinginterpreters.lox;

import java.util.HashMap;
import java.util.Map;

class Environment {
    final Environment enclosing; // Referência ao escopo pai (externo)
    final Map<String, Object> values = new HashMap<>();

    // Construtor para o escopo global (sem pai)
    Environment() {
        enclosing = null;
    }

    // Construtor para escopos locais (com pai)
    Environment(Environment enclosing) {
        this.enclosing = enclosing;
    }

    Object get(Token name) {
        if (values.containsKey(name.lexeme)) {
            return values.get(name.lexeme);
        }

        // Se não achou aqui, tenta no pai (recursivamente)
        if (enclosing != null) return enclosing.get(name);

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    // Define uma nova variável no escopo atual
    void define(String name, Object value) {
        values.put(name, value);
    }

    // Atribui (atualiza) uma variável existente
    void assign(Token name, Object value) {
        if (values.containsKey(name.lexeme)) {
            values.put(name.lexeme, value);
            return;
        }

        // Se não está aqui, tenta atualizar no pai
        if (enclosing != null) {
            enclosing.assign(name, value);
            return;
        }

        throw new RuntimeError(name, "Undefined variable '" + name.lexeme + "'.");
    }

    // =========================
    // === NOVOS MÉTODOS =======
    // =========================

    Environment ancestor(int distance) {
        Environment environment = this;
        for (int i = 0; i < distance; i++) {
            environment = environment.enclosing;
        }
        return environment;
    }

    Object getAt(int distance, String name) {
        return ancestor(distance).values.get(name);
    }

    void assignAt(int distance, Token name, Object value) {
        ancestor(distance).values.put(name.lexeme, value);
    }
}