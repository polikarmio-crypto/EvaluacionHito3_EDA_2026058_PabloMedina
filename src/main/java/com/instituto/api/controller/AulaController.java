package com.instituto.api.controller;

import com.instituto.api.service.AulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/aula")
public class AulaController {

    @Autowired
    private AulaService aulaService;

    // GET /aula
    @GetMapping
    public Map<String, Object> mostrarMatriz() {
        Map<String, Object> response = new LinkedHashMap<>();
        int[][] matriz = aulaService.obtenerMatriz();
        response.put("descripcion", "0 = libre, 1 = ocupado");
        response.put("dimensiones", "5x5");
        response.put("matriz", matriz);
        response.put("ocupados", aulaService.contarOcupados());
        return response;
    }

    // GET /aula/ocupados
    @GetMapping("/ocupados")
    public Map<String, Object> contarOcupados() {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("asientos_ocupados", aulaService.contarOcupados());
        response.put("asientos_libres", 25 - aulaService.contarOcupados());
        response.put("capacidad_total", 25);
        return response;
    }

    // GET /aula/ocupar?fila=1&columna=2
    @GetMapping("/ocupar")
    public Map<String, Object> ocuparAsiento(@RequestParam int fila, @RequestParam int columna) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", aulaService.ocuparAsiento(fila, columna));
        response.put("asientos_ocupados_ahora", aulaService.contarOcupados());
        return response;
    }

    // GET /aula/liberar?fila=1&columna=2
    @GetMapping("/liberar")
    public Map<String, Object> liberarAsiento(@RequestParam int fila, @RequestParam int columna) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("mensaje", aulaService.liberarAsiento(fila, columna));
        response.put("asientos_ocupados_ahora", aulaService.contarOcupados());
        return response;
    }
}
