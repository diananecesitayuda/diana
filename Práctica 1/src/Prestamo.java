import java.util.Scanner;

public class Prestamo {
    private Cuenta cuenta;

    private double interes;
    private int años;
    private double cuota;
    private double capital;

    public Prestamo(Cuenta cuenta, double interes, int años, double cuota, double capital) {
        this.cuenta = cuenta;
        this.interes = interes;
        this.años = años;
        this.cuota = cuota;
        this.capital = capital;
    }
    public Prestamo(){ }

    public double getCuota() {
        return cuota;
    }

    public void setCuota(double cuota) {
        this.cuota = cuota;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public int getAños() {
        return años;
    }

    public void setAños(int años) {
        this.años = años;
    }


    public Prestamo crearprestamo(Cuenta cuenta) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuánto dinero quiere de préstamo?: ");
        capital = teclado.nextDouble();
        System.out.println("Introduce tu interes (0-100): ");
        interes = teclado.nextInt();
        System.out.println("Introduce los años en los que quiera devolver el préstamo: ");
        años = teclado.nextInt();

        if(interes >=0 && interes<100){
            interes =(interes/100);
            double interesmensual = interes/12;
            double meses  = años*12;
            double pow = Math.pow(1+interesmensual,meses);
            double cuota = (capital*interesmensual*pow)/(pow-1);
            System.out.printf("Tu cuota: "+"%.2f\n",cuota);
            System.out.println("  ");
            double capitalvivo = capital;

            System.out.printf("\t\t Pago Mensual"+"\t Intereses"+"\t\t Amortizado"+"\t\t Capital Vivo\n");
            System.out.printf("0\t\t\t0\t\t\t\t0\t\t\t\t0\t\t\t\t%.2f\n",capitalvivo);


            for (int i = 1; i <= meses; i++){
                int mes = i;

                double interesesabonados = capitalvivo*interesmensual;
                double capitalamortizado = cuota - interesesabonados;
                capitalvivo = capitalvivo - capitalamortizado;




                if (i<=20 || i>meses-20){
                    System.out.printf("%01d\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\n",i,cuota,interesesabonados,capitalamortizado,capitalvivo);

                }
                if(i==21){
                    System.out.println("------------------------------------------------------------------------");
                }
            }

        } else {
            System.out.println("ERROR 404");
        }


        return this;
    }
    public void guardarPréstamo(Prestamo[] prestamos, int contadors, Prestamo prestamo) {
        if (cuenta != null) {
            if (contadors == 0) {
                prestamos[0] =prestamo;
            }
            else if (contadors > 0 && contadors < 50) {
                prestamos[contadors++] = prestamo;

            } else if (contadors > 50)
                System.out.println("No se pueden realizar más operaciones.");
        }
    }

}