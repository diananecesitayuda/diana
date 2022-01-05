import javax.sound.midi.Soundbank;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Scanner;

public class Cuenta {

    private int a1 , a2 , a3 , a4 ;
    private int b1 , b2 , b3 , b4 ;
    private int r1, r2;
    private long nc;
    private long ncc;
    private String numeroCuenta;
    private  double dinero=0;
    private int contadorcuentas;

    private Cliente cliente;
    private Cliente[] clientes = new Cliente[20];
    private Cuenta cuenta;
    private Cuenta[] cuentas = new Cuenta[10];

    @Override
    public String toString() {
        return "Cuenta{" +
                "a1=" + a1 +
                ", a2=" + a2 +
                ", a3=" + a3 +
                ", a4=" + a4 +
                ", b1=" + b1 +
                ", b2=" + b2 +
                ", b3=" + b3 +
                ", b4=" + b4 +
                ", r1=" + r1 +
                ", r2=" + r2 +
                ", ncc=" + ncc +
                ", dinero=" + dinero +
                '}';
    }


    public Cuenta(int a1, int a2, int a3, int a4, int b1, int b2, int b3, int b4, int r1, int r2, long ncc, String numeroCuenta, double dinero, Cliente cliente, Cliente[] clientes) {
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
        this.b1 = b1;
        this.b2 = b2;
        this.b3 = b3;
        this.b4 = b4;
        this.r1 = r1;
        this.r2 = r2;
        this.ncc = ncc;
        this.numeroCuenta = numeroCuenta;
        this.dinero = dinero;
        this.cliente = cliente;
        this.clientes = clientes;

    }

    public Cuenta(){ }

    public int getContadorcuentas() {
        return contadorcuentas;
    }

    public void setContadorcuentas(int contadorcuentas) {
        this.contadorcuentas = contadorcuentas;
    }

    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente[] getClientes() {
        return clientes;
    }
    public void setClientes(Cliente[] clientes) {
        this.clientes = clientes;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Cuenta[] getCuentas() {
        return cuentas;
    }
    public void setCuentas(Cuenta[] cuentas) {
        this.cuentas = cuentas;
    }

    public int getA1() {return a1;}
    public void setA1(int a1) {this.a1 = a1;}
    public int getA2() {return a2;}
    public void setA2(int a2) {this.a2 = a2;}
    public int getA3() {return a3;}
    public void setA3(int a3) {this.a3 = a3;}
    public int getA4() {return a4;}
    public void setA4(int a4) {this.a4 = a4;}
    public int getB1() {return b1;}
    public void setB1(int b1) {this.b1 = b1;}
    public int getB2() {return b2;}
    public void setB2(int b2) {this.b2 = b2;}
    public int getB3() {return b3;}
    public void setB3(int b3) {this.b3 = b3;}
    public int getB4() {return b4;}
    public void setB4(int b4) {this.b4 = b4;}
    public int getR1() {return r1;}
    public void setR1(int r1) {this.r1 = r1;}
    public int getR2() {return r2;}
    public void setR2(int r2) {this.r2 = r2;}
    public long getNc() {return nc;}
    public void setNc(long nc) {this.nc = nc;}
    public long getNcc() {return ncc;}
    public void setNcc(long ncc) {this.ncc = ncc;}
    public String getNumeroCuenta() {return numeroCuenta;}
    public void setNumeroCuenta(String numeroCuenta) {this.numeroCuenta = numeroCuenta;}
    public double getDinero() {return dinero;}
    public void setDinero(double dinero) {
        this.dinero = dinero;
    }


    public Cuenta crearcuenta(Cliente[] clientes, Cliente cliente, Cuenta[] cuentas, Cuenta cuenta, int contadorcuentas) {

        Scanner tec =  new Scanner(System.in);
        cuentaBancaria(tec);

        int a1 = 9, a2 = 0, a3 = 1, a4 = 0;
        setA1(a1);
        setA2(a2);
        setA3(a3);
        setA4(a4);
        int b1 = 0, b2 = 2, b3 = 0, b4 = 1;
        setB1(b1);
        setB2(b2);
        setB3(b3);
        setB4(b4);

        int r1 = 0, r2 = 0;
        long nc = (long) (Math.random() * 9999999999L + 1000000000L);


        int resto1 = (int) (6 * b4 + 3 * b3 + 7 * b2 + 9 * b1 + 10 * a4 + 5 * a3 + 8 * a2 + 4 * a1) % 11;
        int c1 = 11 - resto1;
        if (c1 < 10){
            r1 = c1;
            setR1(r1);
        }
        else if (c1 == 10){
            r1 = 1;
            setR1(r1);
        }
        else if (c1 == 11){
            r1 = 0;
            setR1(r1);
        }




        int resto2 = (int) (((nc / 1000000000) + 2 * (nc /100000000%10) + 4 * (nc /10000000%10) + 8 * (nc /1000000%10)
                + 5 * (nc %100000%10) + 10 * (nc %10000%10) + 9 * (nc %1000%10) + 7 * (nc %100%10) + 3 * (nc %10) + 6 * nc) % 11);

        int c2 = 11 - resto2;

        if (c2 < 10)  {
            r2 = c2;
            setR2(r2);
        }
        else if (c2 == 10) {
            r2 = 1;
            setR2(r2);
        }
        else if (c2 == 11) {
            r2 = 0;
            setR2(r2);
        }



        long ncc = (long) ((nc /100000000)%10) + ((nc /10000000)%10) + ((nc /1000000)%10) + ((nc  /100000)%10) + ((nc /10000)%10) + ((nc / 1000)%10) + ((nc / 100)%10) + (nc / 10) + nc;
        setNcc(ncc);
        String numeroCuenta=""+ a1 +""+ a2 +""+a3+""+ a4 +""+b1+""+b2+""+b3+""+b4+""+r1+""+r2+""+ncc+"";

        cuenta = new Cuenta(a1,a2,a3,a4,b1,b2,b3,b4,r1,r2,ncc,numeroCuenta,dinero,cliente,clientes);

        System.out.println("Numero de cuenta: "+numeroCuenta);
        System.out.println("Dinero: "+dinero+" €");

        return  cuenta;

    }


    public boolean comprobarCuenta(Cuenta[] cuentas, int contadorcuentas){
        boolean comprobar = false;

        for (int i = 0; i < contadorcuentas; i++) {

            if(cuentas[i] != null) {

                if (cuentas[i].getNcc() == this.ncc) {

                    comprobar= false;

                }else System.out.println("ncc no coincide?");

                comprobar = true;

            } else System.out.println("cuenta vacía");
        }
        return comprobar;
    }





    enum CuentaBancaria{
        AHORRO, CORRIENTE, RENUMERADA
    }



    public CuentaBancaria cuentaBancaria(Scanner tec){

        System.out.println("\n 1.Cuenta corriente \n 2.Cuenta de ahorro \n 3.Cuenta renumerada");
        System.out.println("Elija el tipo de cuenta que desea usar: ");

        CuentaBancaria cuentaBancaria = CuentaBancaria.valueOf(tec.nextLine());

        switch (cuentaBancaria){
            case CORRIENTE:
                System.out.println("Cuenta corriente.");
                break;
            case AHORRO:
                System.out.println("Cuenta de ahorro.");
                break;
            case RENUMERADA:
                System.out.println("Cuenta renumerada");
                break;
            default:
                System.out.println("opcion no disponible o incorrecta");
        }
        return cuentaBancaria;
    }
}