package com.example.model;

public enum Category {

    KARTA_GRAFICZNA("Karta graficzna"),
    PLYTA_GLOWNA("Płyta główna"),
    DYSK_TWARDY("Dysk twardy"),
    RAM("Pamięć RAM");

    private final String name;

    Category(final String name) {
        this.name = name;
    }
}
