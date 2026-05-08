package com.instituto.api.controller;

import com.instituto.api.estructuras.ListaEstudiantes;
import com.instituto.api.model.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estudiantes")
public class EstudiantesController {

    @Autowired
    private ListaEstudiantes listaEstudiantes;

    // GET /estudiantes/agregar?nombre=Ana&puntaje=95&id=1
    @GetMapping("/agregar")
    public Map<String, Object> agregarEstudiante(
            @RequestParam int id,
            @RequestParam String nombre,
            @RequestParam double puntaje) {

        Map<String, Object> response = new LinkedHashMap<>();
        Estudiante estudiante = new Estudiante(id, nombre, puntaje);
        String mensaje = listaEstudiantes.insertar(estudiante);
        response.put("mensaje", mensaje);
        response.put("total_estudiantes", listaEstudiantes.getTamanio());
        return response;
    }

    // GET /estudiantes
    @GetMapping
    public Map<String, Object> mostrarEstudiantes() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Estudiante> lista = listaEstudiantes.mostrarTodos();
        response.put("estudiantes", lista);
        response.put("total", lista.size());
        return response;
    }

    // GET /estudiantes/ordenados
    @GetMapping("/ordenados")
    public Map<String, Object> mostrarOrdenados() {
        Map<String, Object> response = new LinkedHashMap<>();
        List<Estudiante> ordenados = listaEstudiantes.obtenerOrdenadosPorPuntaje();
        response.put("descripcion", "Estudiantes aprobados (puntaje >= 51) ordenados de mayor a menor puntaje");
        response.put("estudiantes_aprobados", ordenados);
        response.put("total_aprobados", ordenados.size());
        return response;
    }

    // GET /estudiantes/buscar/Juan
    @GetMapping("/buscar/{nombre}")
    public Map<String, Object> buscarEstudiante(@PathVariable String nombre) {
        Map<String, Object> response = new LinkedHashMap<>();
        Estudiante encontrado = listaEstudiantes.buscarPorNombre(nombre);
        if (encontrado != null) {
            response.put("encontrado", true);
            response.put("estudiante", encontrado);
        } else {
            response.put("encontrado", false);
            response.put("mensaje", "No se encontró ningún estudiante con el nombre: " + nombre);
        }
        return response;
    }
}
