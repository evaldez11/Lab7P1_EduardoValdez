/*
+
* Cli1ck nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_eduardovaldez;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author guali
 */
public class Lab7P1_EduardoValdez {

    /**
     * @param args the command line arguments
     */
    static Scanner leer = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.println("**********Menu**********\n1. Tres en Raya\n2. Punto de Silla\n3. Salir del programa");
        int opcion = leer.nextInt();

        switch (opcion) {
            case 1:
                boolean validacion;
                System.out.println("**********Bienvenido al ¡TRES EN RAYA!**********");
                System.out.println("Tablero Actual");
                int[][] matrices;
                matrices = generartablero(3, 3);
                imprimir(matrices);
                validacion = false;
                System.out.println("Es el turno de X");
                System.out.println("Ingrese la fila (0, 1, 2): ");
                int fila = leer.nextInt();
                System.out.println("Ingrese la columna (0, 1, 2): ");
                int columna = leer.nextInt();

                if (fila >= 0 && fila <= 2 && columna >= 0 && columna <= 2) {
                    validacion = true;
                    System.out.println("El usuario ha elegido la posicion (" + fila + " , " + columna + ")");
                    System.out.println("Tablero actual");
                    posicion0(fila, columna, matrices);
                } else {
                    validacion = false;
                    System.out.println("Los numeros no son validos");
                    System.out.println("Ingrese la fila (0, 1, 2): ");
                    fila = leer.nextInt();
                    System.out.println("Ingrese la columna (0, 1, 2): ");
                    columna = leer.nextInt();
                }

                while (validacion = true) {
                    matrices = validar(fila, columna, matrices);
                    if (Ganador(matrices, 1)) {

                        System.out.println("El jugador ha ganado");
                        break;
                    }
                    System.out.println("Ingrese la fila (0, 1, 2): ");
                    fila = leer.nextInt();
                    System.out.println("Ingrese la columna (0, 1, 2): ");
                    columna = leer.nextInt();
                    System.out.println("El usuario ha elegido la posicion (" + fila + " , " + columna + ")");
                    System.out.println("Tablero actual");
                    posicion0(fila,columna,matrices);
                    if (Ganador(matrices,2)){
                        System.out.println("La maquina gano");
                        break;
                    }
                }

                break;
            case 2:
                System.out.print("Ingrese la cantidad de filas: ");
                int filamatriz = leer.nextInt();

                System.out.print("Ingrese la cantidad de columnas: ");
                int columnamatriz = leer.nextInt();

                int[][] matriz;

                matriz = llenarRandom(filamatriz, columnamatriz);

                imprimirmatriz(matriz);

                break;
            case 3:
                System.out.println("Salio del programa");
                break;
            default:
                System.out.println("Opcion no valida");

        }//fin del switch
    }

    public static int[][] generartablero(int fila, int columna) {
        int[][] temporal = new int[fila][columna];
        return temporal;
    }

    public static void imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("[");
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j]==1){
                    System.out.print("X");
                }else if( matriz[i][j]==2){
                    System.out.print("0");
                }else{
                    System.out.print(" ");
                }
                if (j != matriz[i].length - 1) {
                    System.out.print(",");
                }
            }
            System.out.println("]");
        }
        System.out.println();
    }

    public static int[][] validar(int fila, int columna, int[][] matrices) {
        if (matrices[fila][columna] == 0) {
            matrices[fila][columna] = 1;
        } else {
            System.out.println("Esta posicion ya ha sido ocupada");
        }
        return matrices;
    }

    public static void posicion0(int fila, int columna, int[][] matrices) {
        if(matrices[fila][columna]==0){
        matrices[fila][columna] = 1;
        imprimir(matrices);

        int columna2 = rand.nextInt(3);
        int fila2 = rand.nextInt(3);

        while (matrices[fila2][columna] != 0) {
            columna = rand.nextInt(3);
            fila = rand.nextInt(3);
        }
        System.out.println("La maquina eligio la posicion (" + fila2 + "," + columna2 + ")");
        matrices[fila2][columna2] = 2;
        imprimir(matrices);
    }else{
            System.out.println("Esta posicion ya ha sido ocupada");
        }
    }
    
   

    public static int[][] llenarRandom(int fila, int columna) {
        int[][] temporal = new int[fila][columna];

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                temporal[i][j] = rand.nextInt(99);
            }
        }
        return temporal;
    }

    public static boolean Ganador(int[][] matrices, int jugador) {
        for (int i = 0; i < 3; i++) {
             if ((matrices[i][0] == jugador && matrices[i][1] == jugador && matrices[i][2] == jugador)||(matrices[0][i] == jugador && matrices[1][i] == jugador && matrices[2][i] == jugador)) { 
                return true;
            }
        }

            if ((matrices[0][0] == jugador && matrices[1][1] == jugador && matrices[2][2] == jugador)|| (matrices[0][2] == jugador && matrices[1][1] == jugador && matrices[2][0] == jugador)) { 
            return true;
        }

        return false;
    }

    public static boolean llenartablero (int[][] matrices){
        for(int i= 0; i<3;i++){
            for (int j = 0; j<3; j++){
                if(matrices [i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimirmatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }
            System.out.println();
        }
    }

    
}
