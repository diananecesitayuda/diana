import java.util.Scanner;

public class mostrar {
    private Cuenta cuenta;
    private Transferencia transferencia;
    private Extraer extraer;
    private Depositar depositar;
    private Prestamo prestamo;

    private int mostrar;

    public int getMostrar() {
        return mostrar;
    }

    public void setMostrar(int mostrar) {
        this.mostrar = mostrar;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }

    public Transferencia getTransferencia() {
        return transferencia;
    }

    public void setTransferencia(Transferencia transferencia) {
        this.transferencia = transferencia;
    }

    public Extraer getExtraer() {
        return extraer;
    }

    public void setExtraer(Extraer extraer) {
        this.extraer = extraer;
    }

    public Depositar getDepositar() {
        return depositar;
    }

    public void setDepositar(Depositar depositar) {
        this.depositar = depositar;
    }

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }


    public mostrar crearmostrar(Cuenta cuenta) {
        Scanner teclado = new Scanner(System.in);
        System.out.print("DINERO \t\t DEPOSITACIÓN \t\t EXTRACCIÓN \t\t TRANSFERENCIA \t\t PRÉSTAMO\n");

        System.out.println(cuenta.getDinero()+" "+depositar.creardepositar(cuenta).getDeposita());

        return this;

    }
}
