package com.instituto.api.controller;

import com.instituto.api.service.CalificacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/notas")
public class NotasController {

    @Autowired
    private CalificacionesService calificacionesService;

    // GET /notas/agregar?valor=90
    @GetMapping("/agregar")
    public Map<String, Object> agregarNota(@RequestParam double valor) {
        Map<String, Object> response = new LinkedHashMap<>();
        String mensaje = calificacionesService.agregarCalificacion(valor);
        response.put("mensaje", mensaje);
        response.put("cantidad_actual", calificacionesService.getCantidad());
        response.put("capacidad_maxima", calificacionesService.getCapacidad());
        return response;
    }

    // GET /notas
    @GetMapping
    public Map<String, Object> mostrarNotas() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("calificaciones", calificacionesService.obtenerCalificaciones());
        response.put("cantidad", calificacionesService.getCantidad());
        response.put("capacidad_maxima", calificacionesService.getCapacidad());
        return response;
    }

    // GET /notas/promedio
    @GetMapping("/promedio")
    public Map<String, Object> mostrarPromedio() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("promedio", calificacionesService.calcularPromedio());
        response.put("nota_aprobacion", calificacionesService.getNotaAprobacion());
        response.put("cantidad_calificaciones", calificacionesService.getCantidad());
        return response;
    }

    // GET /notas/max
    @GetMapping("/max")
    public Map<String, Object> mostrarMax() {
        Map<String, Object> response = new LinkedHashMap<>();
        double max = calificacionesService.obtenerMax();
        if (max == -1) {
            response.put("mensaje", "No hay calificaciones registradas.");
        } else {
            response.put("nota_maxima", max);
        }
        return response;
    }

    // GET /notas/min
    @GetMapping("/min")
    public Map<String, Object> mostrarMin() {
        Map<String, Object> response = new LinkedHashMap<>();
        double min = calificacionesService.obtenerMin();
        if (min == -1) {
            response.put("mensaje", "No hay calificaciones registradas.");
        } else {
            response.put("nota_minima", min);
        }
        return response;
    }
}
