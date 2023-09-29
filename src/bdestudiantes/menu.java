/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bdestudiantes;

import java.util.Scanner;

/**
 *
 * @author ramir
 */
public class menu {

    public static void ejecucion() {

        estudiante obj1 = new estudiante();

        Scanner entrada = new Scanner(System.in);

        while (true) {
            System.out.println(" SISTEMA VERIFICACION DE ALUMNOS" + "\n");
            System.out.println("- ELIGE LA OPERACION QUE DESEAS -" + "\n");
            System.out.println("*********************************");
            System.out.println("*      1. Listar alumnos        *");
            System.out.println("*      2. nuevo registro        *");
            System.out.println("*      3. modificar registro    *");
            System.out.println("*      4. eliminar registro     *");
            System.out.println("*      5. Salir                 *");
            System.out.println("*********************************" + "\n");

            int opcion = entrada.nextInt();
            
            
            switch (opcion) {
                //lamado al metodo listar
                case 1:
                    obj1.listar();
                    System.out.println("");

                    break;

                case 2:
                    //llamado al metodo crear
                    System.out.println("Ingrese el nombre del estudiante: ");
                    String nombre = entrada.next();

                    System.out.println("Ingrese el apellido del estudiante: ");
                    String apellido = entrada.next();

                    System.out.println("Ingrese el nivel del estudiante: ");
                    String nivel = entrada.next();

                    System.out.println("Ingrese el grado del estudiante: ");
                    String grado = entrada.next();
                    
                    System.out.println("Ingrese la seccion del estudiante: ");
                    String seccion = entrada.next();
                    System.out.println("");

                    obj1.crear(nombre, apellido, nivel, grado, seccion);

                    break;

                case 3:
                    //este metodo primero verifica si el alumno esta en en la lista y luego modifica
                    System.out.println("Ingrese el ID del estudiante que desea modificar: ");
                    int idEstudiante = entrada.nextInt();
                    entrada.nextLine();
                    
                    //verifica si el alumno esta en la lista con el metodo status_estudiante
                    if (obj1.status_estudiante(idEstudiante)) {

                        System.out.println("Ingrese el nuevo nombre: ");
                        String nuevoNombre = entrada.nextLine();

                        System.out.println("Ingrese el nuevo apellido: ");
                        String nuevoApellido = entrada.nextLine();

                        System.out.println("Ingrese el nuevo nivel: ");
                        String nuevoNivel = entrada.nextLine();

                        System.out.println("Ingrese el nuevo grado: ");
                        String nuevoGrado = entrada.nextLine();
                        System.out.println("Ingrese el nuevo grado: ");
                        String nuevaSeccion = entrada.nextLine();

                        obj1.modificar(idEstudiante, nuevoNombre, nuevoApellido, nuevoNivel, nuevoGrado, nuevaSeccion);
                    } else {
                        System.out.println("El ID del estudiante no existe.");
                    }
                    break;

                case 4:
                    //este metodo verifica si el alumno esta en la lista y luego elimina
                    System.out.println("Ingrese el ID del estudiante que desea eliminar: ");
                    int idEstudiante1 = entrada.nextInt();

                    if (obj1.status_estudiante(idEstudiante1)) {
                        obj1.eliminar(idEstudiante1);
                    }else{
                    System.out.println("El ID del estudiante no existe.");
                    }
                    break;

                case 5:
                    // sale del menu
                    System.out.println("Gracias por su preferencia...");
                    System.exit(0);
                    break;

            }

        }

    }

    public static void main(String[] args) {
        menu.ejecucion();
    }

}
