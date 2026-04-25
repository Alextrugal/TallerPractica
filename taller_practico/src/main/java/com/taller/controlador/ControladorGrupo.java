package com.taller.controlador;

import com.taller.servicio.GrupoService;
import com.taller.vista.VistaGrupo;

public class ControladorGrupo {
    private GrupoService service = new GrupoService();
    private VistaGrupo vista = new VistaGrupo();

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> { int idM = vista.pedirEntero("ID Materia: "); int idD = vista.pedirEntero("ID Docente: "); String a = vista.pedirTexto("Aula: "); String h = vista.pedirTexto("Horario: "); service.crearGrupo(idM, idD, a, h); vista.mostrarMensaje("Grupo creado."); }
                case 2 -> vista.mostrarLista(service.listarGrupos());
                case 3 -> { int id = vista.pedirEntero("ID Grupo: "); int idM = vista.pedirEntero("ID Materia: "); int idD = vista.pedirEntero("ID Docente: "); String a = vista.pedirTexto("Aula: "); String h = vista.pedirTexto("Horario: "); service.actualizarGrupo(id, idM, idD, a, h); vista.mostrarMensaje("Actualizado."); }
                case 4 -> { int id = vista.pedirEntero("ID a eliminar: "); service.eliminarGrupo(id); vista.mostrarMensaje("Eliminado."); }
                case 0 -> salir = true;
            }
        }
    }
}