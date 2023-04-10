package com.descartes_api.excepciones;

import com.descartes_api.model.AspirantBasic;

public class Exceptions_duplicate_AspirantBasic extends RuntimeException {
    public Exceptions_duplicate_AspirantBasic(String message) {
        super(message);
    }
}
