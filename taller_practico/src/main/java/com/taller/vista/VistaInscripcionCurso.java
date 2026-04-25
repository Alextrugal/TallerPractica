package com.taller.vista;

import com.taller.modelo.InscripcionCurso;
import com.taller.modelo.Materia;
import java.util.List;
import java.util.Scanner;

public class VistaInscripcionCurso {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n=== GESTIÓN DE INSCRIPCIONES ===");
        System.out.println("1. Inscribirse en curso");
        System.out.println("2. Listar inscripciones");
        System.out.println("3. Actualizar inscripción");
        System.out.println("4. Eliminar inscripción");
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

    public void mostrarLista(List<InscripcionCurso> lista) {
        if (lista.isEmpty()) { System.out.println("No hay inscripciones registradas."); return; }
        lista.forEach(System.out::println);
    }

    public void mostrarMensaje(String msg) { System.out.println(msg); }
    public float pedirFlotante(String mensaje) {
    System.out.print(mensaje);
    return Float.parseFloat(sc.nextLine());
}
}