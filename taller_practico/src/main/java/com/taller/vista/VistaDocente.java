package com.taller.vista;

import com.taller.modelo.Docente;
import java.util.List;
import java.util.Scanner;

public class VistaDocente {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE DOCENTES ===");
        System.out.println("1. Crear docente");
        System.out.println("2. Listar docentes");
        System.out.println("3. Actualizar docente");
        System.out.println("4. Eliminar docente");
        System.out.println("0. Volver");
        System.out.print("Opción: ");
        return Integer.parseInt(sc.nextLine());
    }

    public String pedirTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    public int pedirEntero(String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(sc.nextLine());
    }

    public void mostrarLista(List<Docente> lista) {
        if (lista.isEmpty()) {
            System.out.println("No hay docentes registrados.");
            return;
        }
        lista.forEach(System.out::println);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}