import java.util.Scanner;

public class Extraer {

    private double extrae=0;
    private double a=0;
    private Cuenta cuenta;

    public Extraer(double extraer, double a, Cuenta cuenta) {
        this.extrae = extraer;
        this.a = a;
        this.cuenta = cuenta;
    }
    public Extraer(){ }

    public double getExtrae() {
        return extrae;
    }

    public void setExtrae(double extrae) {
        this.extrae = extrae;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Extraer crearextraer(Cuenta cuenta){
        Scanner teclado = new Scanner(System.in);
        System.out.print("¿Cuánto dinero quiere usted extarer?: ");

        extrae= teclado.nextDouble();
        a = cuenta.getDinero() - extrae;

        if (a<0) {
            System.out.println("No se puede extraer dinero");
            return this;

        }
        if(a>=0){
            cuenta.setDinero(a);
            System.out.println("Dinero actual: " +cuenta.getDinero());

        }

     return this;
    }
    public void imprimir(){
        System.out.println("\tEXTRACCIÓN");
        System.out.print(extrae);
        System.out.println(" ");
    }

    public void guardarExttraer(Extraer[] extraers, int contadors, Extraer extraer) {
        if (cuenta != null) {
            if (contadors == 0) {
                extraers[0] = extraer;
            }
            else if (contadors > 0 && contadors < 50) {
                extraers[contadors++] = extraer;

            } else if (contadors > 50)
                System.out.println("No se pueden realizar más operaciones.");
        }
    }
}
