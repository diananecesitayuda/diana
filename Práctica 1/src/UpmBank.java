import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.xml.transform.sax.SAXSource;
import java.util.Scanner;

public class UpmBank {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Scanner tecladoNumerico = new Scanner(System.in);

        int continuar = 1;
        int dia, mes , año;
        int contadorclientes = 0;
        int contadorcuentas = 0;

        String nombre = null;
        String correo = null;
        fecha nueva = null;

        menu menu = new menu();
        mostrar mostrar = new mostrar();

        Cliente cliente = new Cliente();
        Cliente[] clientes = new Cliente[20];
        Cuenta cuenta = new Cuenta();
        Cuenta[] cuentas = new Cuenta[10];

        Extraer extraer = new Extraer();
        Depositar depositar = new Depositar();
        Transferencia transferencia = new Transferencia();
        Prestamo prestamo = new Prestamo();


        do {
            switch (menu.menu(teclado)) {
                case 1:
                    do {
                        System.out.println("\nIntroduce fecha de nacimiento: ");
                        System.out.println("Día: ");
                        dia = teclado.nextInt();
                        System.out.println("Mes: ");
                        mes = teclado.nextInt();
                        System.out.println("Año: ");
                        año = teclado.nextInt();

                        if (fecha.comprobarFecha(dia, mes, año)) {
                            nueva = new fecha(dia, mes, año);
                            fecha.comprobarFecha(dia, mes, año);
                        } else { System.out.println("INCORRECTO"); }

                        if (nueva != null) {
                            nueva.imprimir();
                            fecha.comprobarFecha(dia, mes, año);}

                    } while (fecha.comprobarFecha(dia, mes, año) == false);

                    cliente.crearCliente(clientes,cliente,contadorclientes);

                    if(cliente.comprobarCliente(clientes,contadorclientes) == false ) {
                        contadorclientes++;

                    }else {System.out.println("ya existe un cliente así."); }


                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();

                    break;

                case 2:
                    boolean correct = true;

                    do {
                        if (cliente.getCorreo() != null) {

                            cuenta.crearcuenta(clientes,cliente,cuentas,cuenta,contadorcuentas);
                            //////////////////////////////////////////// PONERLO EN LA FUNCION ENLAZAR ??

                            if(cuenta.comprobarCuenta(cuentas,contadorcuentas)==false){
                                cliente.guardarCuenta(cuentas,contadorcuentas,cuenta);
                                cliente.enlazarCuentaCliente();
                                contadorcuentas++;

                            }else System.out.println("ya existe una cuenta");

                            //////////////////////////////////////////////////


                        } else {
                            System.out.println("Necesitas primero darte de alta");
                            correct = true;
                        }

                    } while (correct == false);

                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 3:
                    do{
                        if (cliente.getNombre() != null ) {
                            System.out.println("Introduce tu nombre: \n");
                            nombre = teclado.next();
                            if (cliente.getNombre().equals(nombre)){
                                correct = true;
                                depositar = depositar.creardepositar(cuenta);
                            }else
                                System.out.println("nombre incorrecto");
                                correct = false;
                        } else
                            System.out.println("Necesitas primero crearte una cuenta bancaria");
                            correct = true;

                    } while(correct ==false);

                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 4:
                    do{
                        if (cliente.getNombre() != null) {
                            System.out.println("Introduce tu nombre: \n");
                            nombre = teclado.next();
                            if (cliente.getNombre().equals(nombre)) {
                                correct = true;
                                extraer = extraer.crearextraer(cuenta);
                            } else {
                                System.out.println("nombre incorrecto");
                                correct = false; }
                        } else { System.out.println("Necesitas primero darte de alta");
                            correct = true; }

                    } while(correct ==false);
                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 5:
                    do{
                        if (cliente.getNombre() != null) {
                            System.out.println("Introduce tu nombre: \n");
                            nombre = teclado.next();
                            if (cliente.getNombre().equals(nombre)) {
                                correct = true;
                                transferencia = transferencia.creartransferencia(cuenta);
                            } else {
                                System.out.println("nombre incorrecto");
                                correct = false; }
                        } else { System.out.println("Necesitas primero darte de alta");
                            correct = true; }

                    } while(correct ==false);
                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 6:
                    do{
                        if (cliente.getNombre() != null) {
                            System.out.println("Introduce tu nombre: \n");
                            nombre = teclado.next();
                            if (cliente.getNombre().equals(nombre)) {
                                correct = true;
                                prestamo = prestamo.crearprestamo(cuenta);
                            } else {
                                System.out.println("nombre incorrecto");
                                correct = false; }
                        } else { System.out.println("Necesitas primero darte de alta");
                            correct = true; }

                    } while(correct ==false);
                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 7:
                    do {
                        if (cliente.getNombre() != null) {
                            System.out.println("Introduce tu nombre: ");
                            nombre = teclado.next();

                            if (cliente.getNombre().equals(nombre)) {
                                correct = true;
                              cliente.imprimir();
                              depositar.imprimir();
                              extraer.imprimir();

                            } else {
                                System.out.println("nombre incorrecto");
                                correct = false;
                            }
                        } else {
                            System.out.println("Necesitas primero crear una cuenta");
                            correct = true;
                        }

                    } while (correct == false);

                    System.out.print("¿Quieres continuar? 1 para continuar y 0 para salir: ");
                    continuar = teclado.nextInt();
                    break;

                case 0:
                    System.out.print("Gracias y tenga un buen día");
                    continuar=0;
                    break;

                default:
                    System.out.print("No está disponible la opción elegida\n");
            }
        }while(continuar==1);
    }



}



