# Instituto API - Hito 3 EDA-111

API REST desarrollada con **Spring Boot** que implementa estructuras de datos fundamentales:
- **Arreglo Unidimensional** para gestión de calificaciones
- **Arreglo Bidimensional** para distribución de asientos en aula
- **Lista Enlazada** con algoritmo de ordenamiento para estudiantes

---

## Requisitos

- Java 17+
- Gradle (incluido via wrapper `./gradlew`)

---

## Cómo ejecutar el proyecto

```bash
# Desde la raíz del proyecto
./gradlew bootRun
```

La API quedará disponible en: `http://localhost:8080`

---

## Estructura del proyecto

```
src/main/java/com/instituto/api/
├── controller/
│   ├── NotasController.java        # Endpoints Parte 1
│   ├── AulaController.java         # Endpoints Parte 2
│   └── EstudiantesController.java  # Endpoints Parte 3
├── model/
│   └── Estudiante.java             # Modelo de datos
├── service/
│   ├── CalificacionesService.java  # Lógica arreglo 1D
│   └── AulaService.java            # Lógica arreglo 2D
├── estructuras/
│   ├── Nodo.java                   # Nodo de la lista enlazada
│   └── ListaEstudiantes.java       # Lista enlazada manual + Bubble Sort
└── InstitutoApiApplication.java    # Clase principal
```

---

## Parte 1: Calificaciones (Arreglo Unidimensional)

Almacena hasta **10 calificaciones** en un arreglo unidimensional.

| Endpoint | Descripción |
|---|---|
| `GET /notas/agregar?valor=90` | Agregar una calificación |
| `GET /notas` | Mostrar todas las calificaciones |
| `GET /notas/promedio` | Mostrar el promedio |
| `GET /notas/max` | Mostrar la nota máxima |
| `GET /notas/min` | Mostrar la nota mínima |

### Ejemplos de peticiones

```bash
curl "http://localhost:8080/notas/agregar?valor=85"
curl "http://localhost:8080/notas/agregar?valor=42"
curl "http://localhost:8080/notas/agregar?valor=90"
curl "http://localhost:8080/notas"
curl "http://localhost:8080/notas/promedio"
curl "http://localhost:8080/notas/max"
curl "http://localhost:8080/notas/min"
```

---

## Parte 2: Aula - Asientos (Arreglo Bidimensional)

Gestiona una matriz **5x5** de asientos. `0` = libre, `1` = ocupado.

| Endpoint | Descripción |
|---|---|
| `GET /aula` | Mostrar la matriz completa |
| `GET /aula/ocupados` | Cantidad de asientos ocupados |
| `GET /aula/ocupar?fila=1&columna=2` | Ocupar un asiento |
| `GET /aula/liberar?fila=1&columna=2` | Liberar un asiento |

> **Nota:** Las filas y columnas van de **0 a 4**.

### Ejemplos de peticiones

```bash
curl "http://localhost:8080/aula"
curl "http://localhost:8080/aula/ocupar?fila=0&columna=0"
curl "http://localhost:8080/aula/ocupar?fila=2&columna=3"
curl "http://localhost:8080/aula/liberar?fila=2&columna=3"
curl "http://localhost:8080/aula/ocupados"
```

---

## Parte 3: Estudiantes (Lista Enlazada + Ordenamiento)

Implementa una **lista enlazada simple** manual. El ordenamiento de aprobados usa **Bubble Sort**.  
Nota de aprobación: **>= 51 puntos**.

| Endpoint | Descripción |
|---|---|
| `GET /estudiantes/agregar?nombre=Ana&puntaje=95&id=1` | Agregar estudiante |
| `GET /estudiantes` | Mostrar todos los estudiantes |
| `GET /estudiantes/ordenados` | Aprobados ordenados de mayor a menor puntaje |
| `GET /estudiantes/buscar/Juan` | Buscar estudiante por nombre |

### Ejemplos de peticiones

```bash
curl "http://localhost:8080/estudiantes/agregar?nombre=Ana&puntaje=95&id=1"
curl "http://localhost:8080/estudiantes/agregar?nombre=Juan&puntaje=40&id=2"
curl "http://localhost:8080/estudiantes/agregar?nombre=Pedro&puntaje=72&id=3"
curl "http://localhost:8080/estudiantes"
curl "http://localhost:8080/estudiantes/ordenados"
curl "http://localhost:8080/estudiantes/buscar/Ana"
```

---

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
- **Gradle**
- **Git / GitHub**
