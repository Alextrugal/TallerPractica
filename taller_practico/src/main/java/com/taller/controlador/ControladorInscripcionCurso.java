package com.taller.controlador;

import com.taller.servicio.InscripcionCursoService;
import com.taller.vista.VistaInscripcionCurso;

public class ControladorInscripcionCurso {
    private InscripcionCursoService service = new InscripcionCursoService();
    private VistaInscripcionCurso vista = new VistaInscripcionCurso();

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> { int idE = vista.pedirEntero("ID Estudiante: "); int idG = vista.pedirEntero("ID Grupo: "); float nota = vista.pedirFlotante("Nota final: "); String est = vista.pedirTexto("Estado (ACTIVO/RETIRADO/APROBADO): "); service.crearInscripcion(idE, idG, nota, est); vista.mostrarMensaje("Inscripción creada."); }
                case 2 -> vista.mostrarLista(service.listarInscripciones());
                case 3 -> { int id = vista.pedirEntero("ID Inscripción: "); int idE = vista.pedirEntero("ID Estudiante: "); int idG = vista.pedirEntero("ID Grupo: "); float nota = vista.pedirFlotante("Nota: "); String est = vista.pedirTexto("Estado: "); service.actualizarInscripcion(id, idE, idG, nota, est); vista.mostrarMensaje("Actualizado."); }
                case 4 -> { int id = vista.pedirEntero("ID a eliminar: "); service.eliminarInscripcion(id); vista.mostrarMensaje("Eliminado."); }
                case 0 -> salir = true;
            }
        }
    }
}