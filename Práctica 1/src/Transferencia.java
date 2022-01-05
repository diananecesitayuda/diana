import java.util.Scanner;

public class Transferencia {
    private double c;
    private double transferencias;
    private Cuenta cuenta;
    private  Transferencia[][] transferenciass = new Transferencia[50][50];


    public Transferencia(double c, double transferencias, Cuenta cuenta) {
        this.c = c;
        this.transferencias = transferencias;
        this.cuenta = cuenta;
    }
    public Transferencia(){ }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getTransferencias() {
        return transferencias;
    }

    public void setTransferencias(double transferencias) {
        this.transferencias = transferencias;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transferencia creartransferencia(Cuenta cuenta) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuánto dinero quiere usted transferir a al segunda cuenta?: ");

        transferencias = teclado.nextDouble();
        c = cuenta.getDinero() - transferencias;

        if (transferencias > cuenta.getDinero()) {
            System.out.println("No se puede transferir el dinero");
            return this;

        }
        if (c >= 0) {
            cuenta.setDinero(c);
            System.out.println("Dinero en la segunda cuenta es : " + transferencias);
            System.out.println("Dinero en la primera cuenta es : " + cuenta.getDinero());

        } else {
            System.out.println("ERROR 404");
        }

        return this;
    }
    public void guardarTransferencia(Transferencia[] transferencias, int contadors, Transferencia transferencia) {
        if (cuenta != null) {
            if (contadors == 0) {
                transferencias[0] = transferencia;
            }
            else if (contadors > 0 && contadors < 50) {
                transferencias[contadors++] = transferencia;

            } else if (contadors > 50)
                System.out.println("No se pueden realizar más operaciones.");
        }
    }
}

