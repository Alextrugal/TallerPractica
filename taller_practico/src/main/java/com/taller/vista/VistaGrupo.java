package com.taller.vista;

import com.taller.modelo.Grupo;
import com.taller.modelo.Materia;
import java.util.List;
import java.util.Scanner;

public class VistaGrupo {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE GRUPOS ===");
        System.out.println("1. Crear grupo");
        System.out.println("2. Listar grupos");
        System.out.println("3. Actualizar grupo");
        System.out.println("4. Eliminar grupo");
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

    public void mostrarLista(List<Grupo> lista) {
        if (lista.isEmpty()) { System.out.println("No hay grupos registrados."); return; }
        lista.forEach(System.out::println);
    }

    public void mostrarMensaje(String msg) { System.out.println(msg); }
}