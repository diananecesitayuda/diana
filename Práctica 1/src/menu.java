import java.util.Scanner;

public class menu {
    private int opcion = 0;

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int menu (Scanner teclado) {

            System.out.println("1. Dar de alta.");
            System.out.println("2. Crear cuenta bancaria.");
            System.out.println("3. Realizar un depósito.");
            System.out.println("4. Realizar una extracción.");
            System.out.println("5. Realizar una transferencia bancaria.");
            System.out.println("6. Solicitar un préstamo.");
            System.out.println("7. Mostrar Datos.");
            System.out.println("0. Salir\n");
            System.out.println("Introduzca una opción: ");
            opcion = teclado.nextInt();

        return opcion;


    }
}
