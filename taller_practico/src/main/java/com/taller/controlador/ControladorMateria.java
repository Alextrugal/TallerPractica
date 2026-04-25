package com.taller.controlador;

import com.taller.modelo.Materia;
import com.taller.servicio.MateriaService;
import com.taller.vista.VistaMateria;
import java.util.List;

public class ControladorMateria {
    private MateriaService service = new MateriaService();
    private VistaMateria vista = new VistaMateria();

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            int opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> crearMateria();
                case 2 -> listarMaterias();
                case 3 -> actualizarMateria();
                case 4 -> eliminarMateria();
                case 0 -> salir = true;
                default -> vista.mostrarMensaje("Opción no válida");
            }
        }
    }

    private void crearMateria() {
        String nombre = vista.pedirTexto("Nombre de la materia: ");
        int creditos = vista.pedirEntero("Créditos: ");
        try {
            service.crearMateria(nombre, creditos);
            vista.mostrarMensaje("Materia creada exitosamente.");
        } catch (Exception e) {
            vista.mostrarMensaje("Error: " + e.getMessage());
        }
    }

    private void listarMaterias() {
        List<Materia> lista = service.listarMaterias();
        vista.mostrarLista(lista);
    }

    private void actualizarMateria() {
        int id = vista.pedirEntero("ID de la materia a actualizar: ");
        String nombre = vista.pedirTexto("Nuevo nombre: ");
        int creditos = vista.pedirEntero("Nuevos créditos: ");
        service.actualizarMateria(id, nombre, creditos);
        vista.mostrarMensaje("Materia actualizada.");
    }

    private void eliminarMateria() {
        int id = vista.pedirEntero("ID de la materia a eliminar: ");
        service.eliminarMateria(id);
        vista.mostrarMensaje("Materia eliminada.");
    }
}