import java.util.Arrays;
import java.util.Scanner;

public class Cliente {

    private String nombre;
    private String apellidos;
    private String correo;
    private long DNI;
    private char letra;
    private int contadorclientes;

    private Cuenta[] cuentas = new Cuenta[10];
    private Cuenta cuenta;
    private Cliente[] clientes = new Cliente[20];
    private Cliente cliente;

    public Cliente(String nombre, String apellidos, String correo, long DNI, char letra, Cuenta[] cuentas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.DNI = DNI;
        this.letra = letra;
        this.cuentas = null;
    }

    public Cliente() {
    }


    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", DNI=" + DNI +
                ", letra=" + letra +
                ", cuentas=" + Arrays.toString(cuentas) +
                '}';
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getApellidos() {return apellidos;}
    public void setApellidos(String apellidos) {this.apellidos = apellidos;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public long getDNI() {return DNI;}
    public void setDNI(long DNI) {this.DNI = DNI;}
    public char getLetra() {return letra;}
    public void setLetra(char letra) {this.letra = letra;}


    ////////////////////////////////////////////////////////////////////------------COMPROBAR-----

    public Cliente[] getClientes() {return clientes;}
    public void setClientes(Cliente[] clientes) {this.clientes = clientes;}

    public int getContadorclientes() {return contadorclientes;}
    public void setContadorclientes(int contadorclientes) {this.contadorclientes = contadorclientes;}

    public Cuenta[] getCuentas() {return cuentas;}
    public void setCuentas(Cuenta[] cuentas) {this.cuentas = cuentas;}

    public Cuenta getCuenta() {return cuenta;}
    public void setCuenta(Cuenta cuenta) {this.cuenta = cuenta;}

    public Cliente getCliente() {return cliente;}
    public void setCliente(Cliente cliente) {this.cliente = cliente;}
    /////////////////////////////////////////////////////////////////7


    public Cliente crearCliente(Cliente[] clientes, Cliente cliente, int contadorclientes) {

        Scanner tecladoNumerico = new Scanner(System.in);
        Scanner teclado = new Scanner(System.in);
        boolean correcto = true;

        System.out.print("\nIntroduce tu nombre: ");
        this.nombre = teclado.nextLine();

        System.out.print("Introduce tus apellidos: ");
        this.apellidos = teclado.nextLine();

        do {
                System.out.print("Introduce tu DNI sin la letra: ");
                this.DNI = tecladoNumerico.nextLong();

                do {
                    System.out.print("Introduce la letra de tu DNI en mayúscula: ");
                    this.letra = teclado.nextLine().charAt(0);
                    int resto = (int) DNI % 23;
                    int resultado = 25;
                    char[] letrasDni = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D',
                            'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

                    for (int i = 0; i < letrasDni.length; i++) {
                        if (this.letra == letrasDni[i]) {
                            resultado = i;
                        }
                    }

                    if (resto == resultado) {
                        correcto = true;
                        System.out.println("DNI CORRECTO");
                        do {
                            System.out.println("Introduce tu correo: ");
                            this.correo = teclado.next();

                            if (correo.contains("@upm.es") || correo.contains("@alumnos.upm.es")) {
                                for (int i = 0; i < correo.length(); i++) {
                                    if ((correo.charAt(i) >= 64 && correo.charAt(i) <= 90)
                                            || (correo.charAt(i) >= 97 && correo.charAt(i) <= 122)
                                            || (correo.charAt(i) >= 46 && correo.charAt(i) <= 57)) {
                                        correcto = true;
                                    } else {
                                        System.out.println("INCORRECTO");
                                        correcto = false;
                                        break;
                                    }
                                }
                                if (correcto) {
                                    System.out.println("CORREO CORRECTO");

                                    cliente = new Cliente(nombre, apellidos, correo, DNI, letra, cuentas);

                                    if (comprobarCliente(clientes, contadorclientes) == false) {
                                        guardarClientes( contadorclientes, cliente);
                                    }else System.out.println("no se guarda");
                                }

                            } else {
                                correcto = false;
                                System.out.println("CORREO INCORRECTO");
                            }

                        } while (!correcto);

                    } else {
                        correcto = false;
                        System.out.println("DNI INCORRECTO");
                    }
                }while(!correcto);
        } while (!correcto);

        return cliente;
    }




    public void imprimir(){
        System.out.println("NOMBRE   APELLIDOS   CORREO    DNI");
        System.out.println(getNombre()+"      "+getApellidos()+"      "+getCorreo()+"   "+getDNI()+getLetra());
    }




    public boolean comprobarCliente(Cliente[] clientes, int contadorclientes){

        boolean comprobar = false;

            for (int i = 0; i < contadorclientes; i++) {

                if(clientes[i] != null) {

                    if (clientes[i].getCorreo().equals(this.correo) || clientes[i].getDNI() == this.DNI) {

                        comprobar = false;

                    }else System.out.println(" no hay parecidos en clientes");

                    comprobar = true;

                } else System.out.println("clientes lista null");

                comprobar = true;
            }
        return comprobar;
    }


    public void guardarClientes(int contadorclientes, Cliente cliente) {

        if (cliente != null) {

            if (contadorclientes == 0) {

                clientes[0] = cliente;

                ///////////////////////////////////////// BORRAR
                System.out.println("Clientes: ");
                for (int i = 0; i < contadorclientes; i++) {
                    System.out.println(clientes[i]);
                }
                ///////////////////////////////////

            } else if (contadorclientes > 0 && contadorclientes < 20) {

                clientes[contadorclientes++] = cliente;

                ///////////////////////////////////////// BORRAR
                System.out.println("Clientes: ");
                for (int i = 0; i < contadorclientes; i++) {
                    System.out.println(clientes[i]);
                }
                ///////////////////////////////////

            } else if (contadorclientes > 20)
                System.out.println("No puedes introducir más clientes");

        }else System.out.println("el cliente está vacío");

    }




    public Cuenta[] obtenerCuentas(Cuenta[] cuentas) {
        return cuentas;
    }

    public Cuenta[] guardarCuenta(Cuenta[] cuentas,int contadorcuentas, Cuenta cuenta) {  /////////////////------------ esta funcion funciona correctamente :)

        if (cuenta != null) {
            if (contadorcuentas == 0) {
                cuentas[0] = cuenta;

                //////////////////////////////////              BORRAR
                System.out.println("___________CUENTAS__________");

                ///////////////////////////////////



            } else if (contadorcuentas > 0 && contadorcuentas < 10) {
                cuentas[contadorcuentas++] = cuenta;

                //////////////////////////////////              BORRAR
                System.out.println("___________CUENTAS__________");

                ///////////////////////////////////


            } else if (contadorcuentas > 10)

                System.out.println("No puedes introducir más cuentas");

        } else System.out.println("la cuenta está vacía");

        return cuentas;
    }

    public Cuenta[] enlazarCuentaCliente() {

        String correo;
        Scanner tec = new Scanner(System.in);
        System.out.println("Introduzca un correo: ");
        correo = tec.nextLine();

        for (int i = 0; i < 10; i++) {

            if(clientes[i] != null) {

                if (clientes[i].getCorreo().equals(correo) ) {

                    cuentas = clientes[i].obtenerCuentas(cuentas);
                    System.out.println("cliente usado:");
                    System.out.println(clientes[i]);
                    System.out.println("-----------------");


                } else System.out.println("correo incorrecto.");
            } else System.out.println("clientes null");
        }
        return cuentas;
    }

}