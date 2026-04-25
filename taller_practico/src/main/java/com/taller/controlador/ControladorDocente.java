package com.taller.controlador;

import com.taller.servicio.DocenteService;
import com.taller.vista.VistaDocente;

public class ControladorDocente {
    private DocenteService service = new DocenteService();
    private VistaDocente vista = new VistaDocente();

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> { String n = vista.pedirTexto("Nombre: "); String e = vista.pedirTexto("Especialidad: "); service.crearDocente(n, e); vista.mostrarMensaje("Docente creado."); }
                case 2 -> vista.mostrarLista(service.listarDocentes());
                case 3 -> { int id = vista.pedirEntero("ID: "); String n = vista.pedirTexto("Nuevo nombre: "); String e = vista.pedirTexto("Nueva especialidad: "); service.actualizarDocente(id, n, e); vista.mostrarMensaje("Actualizado."); }
                case 4 -> { int id = vista.pedirEntero("ID a eliminar: "); service.eliminarDocente(id); vista.mostrarMensaje("Eliminado."); }
                case 0 -> salir = true;
            }
        }
    }
}