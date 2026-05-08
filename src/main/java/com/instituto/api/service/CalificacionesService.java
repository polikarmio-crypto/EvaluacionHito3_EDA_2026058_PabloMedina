package com.instituto.api.service;

import org.springframework.stereotype.Service;

@Service
public class CalificacionesService {

    private static final int CAPACIDAD = 10;
    private static final int NOTA_APROBACION = 51;

    private final double[] calificaciones = new double[CAPACIDAD];
    private int cantidad = 0;

    public String agregarCalificacion(double valor) {
        if (cantidad >= CAPACIDAD) {
            return "Error: el arreglo ya está lleno (máximo " + CAPACIDAD + " calificaciones).";
        }
        calificaciones[cantidad] = valor;
        cantidad++;
        return "Calificación " + valor + " agregada en la posición " + (cantidad - 1) + ".";
    }

    public double[] obtenerCalificaciones() {
        double[] resultado = new double[cantidad];
        for (int i = 0; i < cantidad; i++) {
            resultado[i] = calificaciones[i];
        }
        return resultado;
    }

    public double calcularPromedio() {
        if (cantidad == 0) return 0;
        double suma = 0;
        for (int i = 0; i < cantidad; i++) {
            suma += calificaciones[i];
        }
        return suma / cantidad;
    }

    public double obtenerMax() {
        if (cantidad == 0) return -1;
        double max = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] > max) max = calificaciones[i];
        }
        return max;
    }

    public double obtenerMin() {
        if (cantidad == 0) return -1;
        double min = calificaciones[0];
        for (int i = 1; i < cantidad; i++) {
            if (calificaciones[i] < min) min = calificaciones[i];
        }
        return min;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getCapacidad() {
        return CAPACIDAD;
    }

    public int getNotaAprobacion() {
        return NOTA_APROBACION;
    }
}
