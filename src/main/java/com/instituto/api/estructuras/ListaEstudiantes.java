package com.instituto.api.estructuras;

import com.instituto.api.model.Estudiante;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ListaEstudiantes {

    private static final int NOTA_APROBACION = 51;

    private Nodo cabeza;
    private int tamanio;

    public ListaEstudiantes() {
        this.cabeza = null;
        this.tamanio = 0;
    }

    // Insertar al final de la lista
    public String insertar(Estudiante estudiante) {
        Nodo nuevo = new Nodo(estudiante);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Nodo actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        tamanio++;
        return "Estudiante '" + estudiante.getNombre() + "' agregado correctamente.";
    }

    // Mostrar todos los estudiantes como lista
    public List<Estudiante> mostrarTodos() {
        List<Estudiante> lista = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            lista.add(actual.estudiante);
            actual = actual.siguiente;
        }
        return lista;
    }

    // Ordenar solo aprobados (puntaje >= 51) de mayor a menor (Bubble Sort)
    public List<Estudiante> obtenerOrdenadosPorPuntaje() {
        // Extraer solo aprobados
        List<Estudiante> aprobados = new ArrayList<>();
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getPuntaje() >= NOTA_APROBACION) {
                aprobados.add(actual.estudiante);
            }
            actual = actual.siguiente;
        }

        // Bubble Sort de mayor a menor
        int n = aprobados.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (aprobados.get(j).getPuntaje() < aprobados.get(j + 1).getPuntaje()) {
                    Estudiante temp = aprobados.get(j);
                    aprobados.set(j, aprobados.get(j + 1));
                    aprobados.set(j + 1, temp);
                }
            }
        }
        return aprobados;
    }

    // Buscar estudiante por nombre
    public Estudiante buscarPorNombre(String nombre) {
        Nodo actual = cabeza;
        while (actual != null) {
            if (actual.estudiante.getNombre().equalsIgnoreCase(nombre)) {
                return actual.estudiante;
            }
            actual = actual.siguiente;
        }
        return null;
    }

    public int getTamanio() {
        return tamanio;
    }
}
