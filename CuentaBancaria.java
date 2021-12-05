package trabajopractico;

import java.util.Scanner;

public class CuentaBancaria {

    //ATRIBUTOS
    String nombreCliente;
    String dniCliente;
    double saldo;
    double ultimoMovimiento;

    //CONSTRUCTORES
    public CuentaBancaria(String nombreCliente, String dniCliente) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
    }


    public CuentaBancaria(String nombreCliente, String dniCliente, double saldo) {
        this.nombreCliente = nombreCliente;
        this.dniCliente = dniCliente;
        this.saldo = saldo;
    }


    //METODOS
    double retirar = 0;
    double depositar = 0;

    public void retirar(double cantidad) {

        this.saldo = this.saldo - cantidad;
        ultimoMovimiento = cantidad;
        retirar = ultimoMovimiento;
    }

    public void depositar(double cantidad) {
        this.saldo = this.saldo + cantidad;
        ultimoMovimiento = cantidad;
        depositar = ultimoMovimiento;
    }

    public void consultarUltimoMovimiento() {
        if (ultimoMovimiento == retirar) {
            System.out.println("El ultimo movimiento fue un retiro: " + " \n Cantidad retirada: " + ultimoMovimiento);
        } else {
            if (ultimoMovimiento == depositar) {
                System.out.println("El ultimo movimiento fue un deposito: " + " \n Cantidad depositada: " + ultimoMovimiento);
            } else {
                if (depositar == 0 && retirar == 0) {
                    System.out.println("No se han realizado transacciones");
                }
            }
        }
    }


    public void mostrarMenu() {
        String opciones;
        System.out.println(" Bienvenido " + nombreCliente + " \n Tu Dni es " + dniCliente);
        do {
            System.out.println("\n ==============" +

                    "\n Opción A: Consultar Saldo " +

                    "\n Opción B: Depositar" +

                    "\n Opción C: Retirar" +

                    "\n Opción D: Consultar Ultimo Movimiento" +

                    "\n Opción E: Salir" + "\n ==============");
            Scanner sc = new Scanner(System.in);

            System.out.print("Introduzca una opcion: ");
            opciones = sc.nextLine();

            switch (opciones.toUpperCase()) {
                case "A":

                    System.out.println("\n --------------" + "\n Tu saldo es : " + saldo + "\n --------------" + "\n");


                    break;

                case "B":
                    double numeroDepositado;

                    System.out.println("\n --------------" + "\n Monto a depositar: " + "\n --------------");
                    numeroDepositado = sc.nextDouble();
                    if (numeroDepositado > 0) {
                        depositar(numeroDepositado);

                        System.out.println("\n --------------" + " \n Saldo depositado: " + numeroDepositado +
                                "\n --------------" + "\n");
                    } else {

                        System.out.println("El saldo depositado es incorrecto, intente otra vez");
                    }

                    break;

                case "C":
                    double numeroRetiro;

                    System.out.println("\n --------------" + " \n Monto a retirar: " + "\n --------------");
                    numeroRetiro = sc.nextDouble();
                    if (numeroRetiro <= saldo) {
                        retirar(numeroRetiro);

                        System.out.println("\n --------------" + " \n Saldo retirado: " + numeroRetiro +
                                "\n --------------" + "\n");
                    } else {

                        System.out.println("Saldo insuficiente, intente otra vez");
                    }

                    break;

                case "D":

                    consultarUltimoMovimiento();


                    break;

                case "E":

                    System.out.println("\n --------------" + "\n Hasta Luego" + "\n --------------" + " \n");

                    System.exit(0);
                    break;

                default:
                    if (opciones != "A" && opciones != "B" && opciones != "C" && opciones != "D" && opciones != "E") {
                        System.out.println("Opcion invalida, intente de nuevo");

                    }

                    break;
            }
        } while (opciones != "E");

    }
}

