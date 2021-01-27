import java.util.Random;

import java.io.IOException;

import java.util.Scanner;

public class Calcular {

    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

    public static void main(String[] args) {

	//primero borramos la pantalla
	try
	{
		if (IS_WINDOWS) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else if (IS_UNIX) {
			System.out.print("\033[H\033[2J");  
            		System.out.flush();
		}	
	}
	catch (Exception e) { /* No hacer nada*/ }

	//indicamos en que sistema operativo estamos
	System.out.println("Nombre Sistema: " + OS);

        	if (IS_WINDOWS) {
			System.out.println("");
            		System.out.println("Me ejecuto en Windows");
        	} else if (IS_UNIX) {
			System.out.println("");
            		System.out.println("Me ejecuto en Linux");
        	} else {
			System.out.println("");
            		System.out.println("Me ejecuto en Otro");
        	}
  
	//hacemos el programa de calcular dos numeros aleatorios
		int num1 = 0;
		int num2 = 0;
		int resultado = 0;
		int numero = 0;

	Random rnd = new Random();
	Scanner reader = new Scanner(System.in);
	num1 = (int)(rnd.nextDouble() * 20 + 0);

	num2 = (int)(rnd.nextDouble() * 20 + 0);

	resultado = num1*num2;
	//System.out.println(num1 + " * " + num2 +" = " + resultado);
	System.out.println("");
	System.out.println("Soy Maria Amparo Mora Calvo. ¿Cuánto es " + num1 + " * " + num2 +"?");

	//a partir de aqui calculamos el tiempo que tarda el usuario en responder
	long TInicio, TFin, tiempo;

	TInicio = System.currentTimeMillis();

	numero = reader.nextInt();

	TFin = System.currentTimeMillis();

	tiempo = TFin - TInicio;
	System.out.println("");
	System.out.println("Has tardado en contestar " + tiempo);

	if (numero == resultado) {
		System.out.println("");
            	System.out.println("Perfecto!, el resultado es " + resultado);
        } else {
		System.out.println("");
            	System.out.println("Te has equivocado, el resultado es " + resultado);
        }

	  }
}