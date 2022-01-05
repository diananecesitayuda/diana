import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Cuenta {

    private int n11 = 9, n12 = 0, n13 = 1, n14 = 0;
    private int n21 = 0, n22 = 2, n23 = 0, n24 = 1;
    private int n31 = 0, n32 = 0;
    private long nc = 0;
    private int opcion2;
    private  double dinero=0;
    private Cliente cliente;
    private String numeroCuenta=""+n11+""+n12+""+n13+""+n14+""+n21+""+n22+""+n23+""+n24+""+n31+""+n32+""+nc+"";

@Override
    public String toString() {
    return "cuenta{" +
            "n11=" + n11 +
            ", n12=" + n12 +
            ", n13=" + n13 +
            ", n14=" + n14 +
            ", n21=" + n21 +
            ", n22=" + n22 +
            ", n23=" + n23 +
            ", n24=" + n24 +
            ", n31=" + n31 +
            ", n32=" + n32 +
            ", nc=" + nc +
            ", opcion2=" + opcion2 +
            ", dinero=" + dinero +
            ", cliente=" + cliente +
            '}';
    }

    public Cuenta(int n11, int n12, int n13, int n14, int n21, int n22, int n23, int n24, int n31, int n32, long nc, int opcion2, double dinero) {
        this.n11 = n11;
        this.n12 = n12;
        this.n13 = n13;
        this.n14 = n14;
        this.n21 = n21;
        this.n22 = n22;
        this.n23 = n23;
        this.n24 = n24;
        this.n31 = n31;
        this.n32 = n32;
        this.nc = nc;
        this.opcion2 = opcion2;
        this.dinero = dinero;
    }
    public Cuenta(){ }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }

    public int getN11() {
        return n11;
    }

    public void setN11(int n11) {
        this.n11 = n11;
    }

    public int getN12() {
        return n12;
    }

    public void setN12(int n12) {
        this.n12 = n12;
    }

    public int getN13() {
        return n13;
    }

    public void setN13(int n13) {
        this.n13 = n13;
    }

    public int getN14() {
        return n14;
    }

    public void setN14(int n14) {
        this.n14 = n14;
    }

    public int getN21() {
        return n21;
    }

    public void setN21(int n21) {
        this.n21 = n21;
    }

    public int getN22() {
        return n22;
    }

    public void setN22(int n22) {
        this.n22 = n22;
    }

    public int getN23() {
        return n23;
    }

    public void setN23(int n23) {
        this.n23 = n23;
    }

    public int getN24() {
        return n24;
    }

    public void setN24(int n24) {
        this.n24 = n24;
    }

    public int getN31() {
        return n31;
    }

    public void setN31(int n31) {
        this.n31 = n31;
    }

    public int getN32() {
        return n32;
    }

    public void setN32(int n32) {
        this.n32 = n32;
    }

    public long getNc() {
        return nc;
    }

    public void setNc(long nc) {
        this.nc = nc;
    }

    public int getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(int opcion2) {
        this.opcion2 = opcion2;
    }

    public Cuenta crearcuenta(Cliente cliente) {

        Scanner teclado = new Scanner(System.in);

        System.out.println("\n 1.Cuenta corriente \n 2.Cuenta de ahorro \n 3.Cuenta renumerada");
        System.out.println("Elija el tipo de cuenta que desea usar: ");

        opcion2 = teclado.nextInt();

                int n11 = 9, n12 = 0, n13 = 1, n14 = 0;
                int n21 = 0, n22 = 2, n23 = 0, n24 = 1;
                int n31 = 0, n32 = 0;
                long nc = 0;

                nc = (long) (Math.random() * 9999999999L + 1000000000L);

                int r1 = (int) (6 * n24 + 3 * n23 + 7 * n22 + 9 * n21 + 10 * n14 + 5 * n13 + 8 * n12 + 4 * n11) % 11;
                int c1 = 11 - r1;
                if (c1 < 10) {
                    n31 = c1;
                }
                if (c1 == 10) {
                    n31 = 1;
                }
                if (c1 == 11) {
                    n31 = 0;

                }

                int r2 = (int) ((nc / 1000000000) + 2 * (nc /100000000%10) + 4 * (nc /10000000%10) + 8 * (nc /1000000%10)
                        + 5 * (nc %100000%10) + 10 * (nc %10000%10) + 9 * (nc %1000%10) + 7 * (nc %100%10) + 3 * (nc %10) + 6 * nc);
                int c2 = 11 - r2;
                if (c2 < 10) {
                    c2 = n32;
                }
                if (c2 == 10) {
                    n31 = 1;
                }
                if (c2 == 11) {
                    n32 = 0;

                }
                int ncc = (int) ((nc / 1000000000) + (nc /100000000%10) + (nc /10000000%10) + (nc /1000000%10) + (nc  /100000%10)
                        + (nc /10000%10) + (nc / 1000) + (nc / 100) + (nc / 10) + nc);

                System.out.println("Tu número bancario: " + n11 + "" + n12 + "" + n13 + "" + n14 + "" + n21 + "" + n22 + "" + n23 + "" + n24 + "" + n31 + "" + n32 + "" + nc);
        System.out.println("Tu dinero: "+dinero);

                return this;
    }

    public boolean comprobarCuenta(Cuenta[] cuentas, int contadors){

        for (int i = 0; i < contadors; i++) {
            if(cuentas[i] != null) {
                if (cuentas[i].numeroCuenta == this.numeroCuenta) {
                    return false;
                }
            }
        } contadors++;
        return true;
    }

    public void guardarCuenta(Cuenta[] cuentas, int contadors, Cuenta cuenta) {
        if (cuenta != null) {
            if (contadors == 0) {
                cuentas[0] = cuenta;
            }
            else if (contadors > 0 && contadors < 10) {
                cuentas[contadors++] = cuenta;

            } else if (contadors > 10)
                System.out.println("No puedes introducir más cuentas");
        }
    }

    enum CuentaBancaria{
    CUENTA_AHORRO, CUENTA_CORRIENTE, CUENTA_RENUMERADA
    }


}