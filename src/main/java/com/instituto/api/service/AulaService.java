package com.instituto.api.service;

import org.springframework.stereotype.Service;

@Service
public class AulaService {

    private static final int FILAS = 5;
    private static final int COLUMNAS = 5;

    private final int[][] asientos = new int[FILAS][COLUMNAS];

    public String ocuparAsiento(int fila, int columna) {
        if (!esValido(fila, columna)) {
            return "Error: posición (" + fila + "," + columna + ") fuera de rango. Use filas 0-4 y columnas 0-4.";
        }
        if (asientos[fila][columna] == 1) {
            return "El asiento (" + fila + "," + columna + ") ya está ocupado.";
        }
        asientos[fila][columna] = 1;
        return "Asiento (" + fila + "," + columna + ") ocupado correctamente.";
    }

    public String liberarAsiento(int fila, int columna) {
        if (!esValido(fila, columna)) {
            return "Error: posición (" + fila + "," + columna + ") fuera de rango. Use filas 0-4 y columnas 0-4.";
        }
        if (asientos[fila][columna] == 0) {
            return "El asiento (" + fila + "," + columna + ") ya está libre.";
        }
        asientos[fila][columna] = 0;
        return "Asiento (" + fila + "," + columna + ") liberado correctamente.";
    }

    public int[][] obtenerMatriz() {
        return asientos;
    }

    public int contarOcupados() {
        int count = 0;
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (asientos[i][j] == 1) count++;
            }
        }
        return count;
    }

    private boolean esValido(int fila, int columna) {
        return fila >= 0 && fila < FILAS && columna >= 0 && columna < COLUMNAS;
    }
}
