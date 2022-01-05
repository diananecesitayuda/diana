import java.util.Scanner;

public class Depositar {
    private double deposita=0;
    private double b = 0;
    private Cuenta cuenta;

    public Depositar(double deposita, double b, Cuenta cuenta) {
        this.deposita = deposita;
        this.b = b;
        this.cuenta = cuenta;
    }
    public Depositar(){ }

    public double getDeposita() {
        return deposita;
    }

    public void setDeposita(double deposita) {
        this.deposita = deposita;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Depositar creardepositar(Cuenta cuenta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuánto dinero quiere usted depositar?: ");

        deposita = teclado.nextDouble();
        b = cuenta.getDinero() + deposita;

        if (b >= 0) {
            cuenta.setDinero(b);
            System.out.println("Dinero actual: " + cuenta.getDinero());

        }

        return this;
    }
    public void imprimir(){
        System.out.println("DEPOSITO");
        System.out.print(deposita);
    }

    public void guardarDepositar(Depositar[] depositars, int contadors, Depositar depositar) {
        if (cuenta != null) {
            if (contadors == 0) {
                depositars[0] = depositar;
            }
            else if (contadors > 0 && contadors < 50) {
                depositars[contadors++] = depositar;

            } else if (contadors > 50)
                System.out.println("No se pueden realizar más operaciones.");
        }
    }
}
