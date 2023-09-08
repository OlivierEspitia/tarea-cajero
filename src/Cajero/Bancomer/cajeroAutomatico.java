package Cajero.Bancomer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class cajeroAutomatico {
	public static void main(String[] args) {

		double saldo = 10000.00;
		String bienvenida = "Bienvenido al cajero Banca Rota";
		int opcion;
		int intentosInvalidos = 0;
		int idNumber;
		ArrayList<String> opciones = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat horaMovimiento = new SimpleDateFormat("YYYY/MM/dd HH:mm");

          System.out.println(bienvenida);
		
		do {
			System.out.println("Selecciona alguna de nuestras siguientes opciones");
			System.out.println("1) Consultar tu saldo");
			System.out.println("2) Retirar dinero");
			System.out.println("3) Realizar depositos");
			System.out.println("4) Quejas respecto a alguna inconformidad");
			System.out.println("5) Ver tus ultimos 5 movientos");
			System.out.println("9) Salir");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				System.out.println("Tu saldo actual es de: " + saldo);
			break;
			case 2:
				System.out.println("Tu saldo actual es de: " + saldo);
				System.out.println("Cuanto deseas retirar: ");
				 double retiro = sc.nextDouble();
				 if (retiro < 6000 && retiro % 50 == 0 && retiro <= saldo) {
					 saldo -= retiro;
					 opciones.add(horaMovimiento.format(new Date()) +  " Retiro de $" + retiro);
					System.out.println("Desea donar $200 pa´ las caguamas de la ch30? (s/n)");
				String donar = sc.next();
				 if ("s".equalsIgnoreCase(donar)) {
		              saldo -= 200;
		            }
		          } else {
		            System.out.println("Cantidad inválida");
		          }
		          break;
			case 3:
				System.out.println("1) Cuenta de cheques");
				System.out.println("2) Tarjeta de crédito");
		          int tipoDeposito = sc.nextInt();
		         
		          System.out.println("Ingrese la cantidad que quieres depositar: ");
		          double cantidadDeposito = sc.nextDouble();
		          if (cantidadDeposito % 50 == 0) {
		        	  if (tipoDeposito == 1) {
		        		  saldo += cantidadDeposito;
		        	  } else {
		        		  saldo -= cantidadDeposito;
		        	  }
		        	  opciones.add(horaMovimiento.format(new Date()) + " Depósito a tarjeta de credito de $" + cantidadDeposito);
		        	  } else {
		        		  System.out.println("La cantidad es invalida");
		        	  }
		          break;
			case 4:
				System.out.println("No estan disponibles por el momento");
		          break;
			case 5:
				System.out.println("Estos son sus ultimos 5 movimientos");
				for(int i = Math.max(opciones.size() - 5, 0 ); i < opciones.size(); i++){
				System.out.println(opciones.get(i));
				}		
			    break;
			    
			case 9:
				System.out.println("Muchas gracias por confiar en cajero Banca Rota");
				break;
		
				default:
					System.out.println(" Este no es un numero valido por favor vuelve a intentar");
					intentosInvalidos++;
					if( intentosInvalidos == 3) {
						System.out.println("Superaste el numero de intentos, reintenta mas tarde.");
					System.exit(0);
					}
		} 	
	} while (opcion != 9);
		
		sc.close();
		}
}
