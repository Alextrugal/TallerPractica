# Taller Práctico - Sistema de Gestión Académica

## Diagrama de Clases

```mermaid
classDiagram
    %% Paquete Modelo
    class Docente {
        -int idDocente
        -String nombre
        -String especialidad
        +Docente()
        +Docente(int, String, String)
        +getIdDocente() int
        +setIdDocente(int)
        +getNombre() String
        +setNombre(String)
        +getEspecialidad() String
        +setEspecialidad(String)
    }

    class Materia {
        -int idMateria
        -String nombreMateria
        -int creditos
        +Materia()
        +Materia(int, String, int)
        +getIdMateria() int
        +setIdMateria(int)
        +getNombreMateria() String
        +setNombreMateria(String)
        +getCreditos() int
        +setCreditos(int)
    }

    class Grupo {
        -int idGrupo
        -int idMateria
        -int idDocente
        -String aula
        -String horario
        +Grupo()
        +Grupo(int, int, int, String, String)
        +getIdGrupo() int
        +setIdGrupo(int)
        +getIdMateria() int
        +setIdMateria(int)
        +getIdDocente() int
        +setIdDocente(int)
        +getAula() String
        +setAula(String)
        +getHorario() String
        +setHorario(String)
    }

    class InscripcionCurso {
        -int idInscripcion
        -int idEstudiante
        -int idGrupo
        -float notaFinal
        -String estado
        +InscripcionCurso()
        +InscripcionCurso(int, int, int, float, String)
        +getIdInscripcion() int
        +setIdInscripcion(int)
        +getIdEstudiante() int
        +setIdEstudiante(int)
        +getIdGrupo() int
        +setIdGrupo(int)
        +getNotaFinal() float
        +setNotaFinal(float)
        +getEstado() String
        +setEstado(String)
    }

    %% Relaciones entre modelos
    Grupo --> Materia : tiene
    Grupo --> Docente : imparte
    InscripcionCurso --> Grupo : pertenece

    %% Paquete DAO
    class DocenteDao {
        +listar() List~Docente~
        +agregar(Docente) boolean
        +actualizar(Docente) boolean
        +eliminar(int) boolean
    }

    class MateriaDao {
        +listar() List~Materia~
        +agregar(Materia) boolean
        +actualizar(Materia) boolean
        +eliminar(int) boolean
    }

    class GrupoDao {
        +listar() List~Grupo~
        +agregar(Grupo) boolean
        +actualizar(Grupo) boolean
        +eliminar(int) boolean
    }

    class InscripcionCursoDao {
        +listar() List~InscripcionCurso~
        +agregar(InscripcionCurso) boolean
        +actualizar(InscripcionCurso) boolean
        +eliminar(int) boolean
    }

    %% Paquete Servicio
    class DocenteService {
        -DocenteDao dao
        +listar() List~Docente~
        +agregar(Docente) boolean
        +actualizar(Docente) boolean
        +eliminar(int) boolean
    }

    class MateriaService {
        -MateriaDao dao
        +listar() List~Materia~
        +agregar(Materia) boolean
        +actualizar(Materia) boolean
        +eliminar(int) boolean
    }

    class GrupoService {
        -GrupoDao dao
        +listar() List~Grupo~
        +agregar(Grupo) boolean
        +actualizar(Grupo) boolean
        +eliminar(int) boolean
    }

    class InscripcionCursoService {
        -InscripcionCursoDao dao
        +listar() List~InscripcionCurso~
        +agregar(InscripcionCurso) boolean
        +actualizar(InscripcionCurso) boolean
        +eliminar(int) boolean
    }

    %% Relaciones Servicio-DAO
    DocenteService --> DocenteDao
    MateriaService --> MateriaDao
    GrupoService --> GrupoDao
    InscripcionCursoService --> InscripcionCursoDao

    %% Paquete Controlador
    class ControladorDocente {
        -DocenteService servicio
        +listar()
        +agregar(Docente)
        +actualizar(Docente)
        +eliminar(int)
    }

    class ControladorMateria {
        -MateriaService servicio
        +listar()
        +agregar(Materia)
        +actualizar(Materia)
        +eliminar(int)
    }

    class ControladorGrupo {
        -GrupoService servicio
        +listar()
        +agregar(Grupo)
        +actualizar(Grupo)
        +eliminar(int)
    }

    class ControladorInscripcionCurso {
        -InscripcionCursoService servicio
        +listar()
        +agregar(InscripcionCurso)
        +actualizar(InscripcionCurso)
        +eliminar(int)
    }

    %% Relaciones Controlador-Servicio
    ControladorDocente --> DocenteService
    ControladorMateria --> MateriaService
    ControladorGrupo --> GrupoService
    ControladorInscripcionCurso --> InscripcionCursoService

    %% Paquete Vista
    class VistaDocente {
        +mostrarMenu()
        +mostrarListado(List~Docente~)
    }

    class VistaMateria {
        +mostrarMenu()
        +mostrarListado(List~Materia~)
    }

    class VistaGrupo {
        +mostrarMenu()
        +mostrarListado(List~Grupo~)
    }

    class VistaInscripcionCurso {
        +mostrarMenu()
        +mostrarListado(List~InscripcionCurso~)
    }

    %% Relaciones Vista-Controlador
    VistaDocente --> ControladorDocente
    VistaMateria --> ControladorMateria
    VistaGrupo --> ControladorGrupo
    VistaInscripcionCurso --> ControladorInscripcionCurso

    %% Clase Main
    class Main {
        +main(String[]) void
    }

    %% Conexión
    class ConexionMySQLDatabase {
        -String url
        -String usuario
        -String password
        +getConnection() Connection
        +cerrarConexion(Connection)
    }

    %% Main usa todos los controladores
    Main --> ControladorDocente
    Main --> ControladorMateria
    Main --> ControladorGrupo
    Main --> ControladorInscripcionCurso

    %% DAO usa la conexión
    DocenteDao --> ConexionMySQLDatabase
    MateriaDao --> ConexionMySQLDatabase
    GrupoDao --> ConexionMySQLDatabase
    InscripcionCursoDao --> ConexionMySQLDatabase
```

## Estructura del Proyecto

| Paquete | Descripción |
|---------|-------------|
| **modelo** | Entidades del sistema: Docente, Materia, Grupo, InscripcionCurso |
| **dao** | Acceso a datos: operaciones CRUD con MySQL |
| **servicio** | Lógica de negocio intermedia |
| **controlador** | Coordinación entre vista y servicio |
| **vista** | Interfaz de usuario (menú y listado) |
| **config** | Conexión a la base de datos MySQL |

## Arquitectura

El proyecto sigue el patrón **MVC (Modelo-Vista-Controlador)** con una capa de servicios intermedia:

```
Vista → Controlador → Servicio → DAO → Modelo
```

## Tecnologías

- **Lenguaje**: Java
- **Base de datos**: MySQL
- **Build tool**: Maven

