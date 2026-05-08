package com.instituto.api.estructuras;

import com.instituto.api.model.Estudiante;

public class Nodo {

    public Estudiante estudiante;
    public Nodo siguiente;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.siguiente = null;
    }
}
