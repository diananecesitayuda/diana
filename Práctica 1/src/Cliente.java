import java.util.Scanner;

public class Cliente {

    private String nombre;
    private String apellidos;
    private String correo;
    private long DNI;
    private char letra;

    private int cuentitas;
    private Cliente cliente;
    private Cuenta[] cuentas;


    public Cliente(String nombre, String apellidos, String correo, long DNI, char letra) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.DNI = DNI;
        this.letra = letra;

    }

    public Cliente() {
    }

    @Override
    public String toString() {
        return "cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                ", DNI=" + DNI +
                ", letra=" + letra +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getDNI() {
        return DNI;
    }

    public void setDNI(long DNI) {
        this.DNI = DNI;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }


    public void crearCliente(Cliente[] clientes, Cliente cliente, int contadors) {

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

                            cliente = new Cliente(nombre, apellidos, correo, DNI, letra);

                            if (comprobarCliente(clientes,contadors)==true) {
                                guardarClientes(clientes, contadors, cliente);
                            } else System.out.println("ya existe una cuenta así");
                        }

                    } else {
                        correcto = false;
                        System.out.println("CORREO INCORRECTO");
                    }

            } while (!correcto) ;

        } else{
            correcto = false;
            System.out.println("DNI INCORRECTO");
        }
        } while (!correcto);

    }

    public void imprimir(){
        System.out.println("NOMBRE   APELLIDOS   CORREO    DNI");
        System.out.println(getNombre()+"      "+getApellidos()+"      "+getCorreo()+"   "+getDNI()+getLetra());
    }


    public boolean comprobarCliente(Cliente[] clientes, int contadors){

            for (int i = 0; i < contadors; i++) {
                if(clientes[i] != null) {
                    if (clientes[i].getCorreo().equals(this.correo) || clientes[i].getDNI() == this.DNI) {
                        return false;
                    }
                }
            } contadors++;
        return true;
    }

    public void guardarClientes(Cliente[] clientes, int contadors, Cliente cliente) {
        if (cliente != null) {
            if (contadors == 0) {
                clientes[0] = cliente;
            }
            else if (contadors > 0 && contadors < 19) {
                    clientes[contadors++] = cliente;

                } else if (contadors > 20)
                    System.out.println("No puedes introducir más clientes");
        }
    }

    public Cliente(Cliente cliente){
        this.cliente = cliente;
        this.cuentas = null;
        this.cuentitas = cuentitas;

    }
    public void enlazarCuentas(Cuenta[] acc){
        cuentas = acc;
    }
    public Cuenta[] obtenerCuentas(Cuenta[] cuentas){
        return cuentas;
    }
    public void enlazarCuentitas(int numero){
        cuentitas = numero;
    }
    public int obtenerCuentitas(int cuentitas){
        return cuentitas;
    }
    public Cliente obtenerCliente(){
        return cliente;
    }


}