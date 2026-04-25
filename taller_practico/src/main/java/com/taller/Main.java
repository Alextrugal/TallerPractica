package com.taller;

import com.taller.controlador.ControladorDocente;
import com.taller.controlador.ControladorGrupo;
import com.taller.controlador.ControladorInscripcionCurso;
import com.taller.controlador.ControladorMateria;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=============================");
            System.out.println("   SISTEMA DE GESTIÓN UNIAJC");
            System.out.println("=============================");
            System.out.println("1. Gestionar Docentes");
            System.out.println("2. Gestionar Materias");
            System.out.println("3. Gestionar Grupos");
            System.out.println("4. Gestionar Inscripciones");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> new ControladorDocente().iniciar();
                case 2 -> new ControladorMateria().iniciar();
                case 3 -> new ControladorGrupo().iniciar();
                case 4 -> new ControladorInscripcionCurso().iniciar();
                case 0 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }

        System.out.println("¡Hasta luego!");
        sc.close();
    }
}