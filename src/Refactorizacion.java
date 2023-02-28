import java.util.Scanner;

public class Refactorizacion {


    // introducimos el numero maximo sobre el que queresmos obtener el conjunto de primos
    private static int introducirNumeroMaximo() {
        Scanner teclado=new Scanner(System.in);
        System.out.println("Introduce el número para la criba de Erastótenes:");
        int numeroMaximo=teclado.nextInt();
        int conjuntoDeNumeros[]=new int[numeroMaximo];
        System.out.println("\nVector inicial hasta :"+numeroMaximo);
        for (int i = 0; i < conjuntoDeNumeros.length; i++) {
            if (i%10==0) System.out.println();
            System.out.print(i+1+"\t");
        }
        return numeroMaximo;
    }

    // seleccionamos los primos
    private static void
    criba(int numeroTamanyoArray, boolean[] esPrimo) {
        int i;
        int j;
        for (i=2; i<Math.sqrt(numeroTamanyoArray)+1; i++) {
            if (esPrimo[i]) {
                // Eliminar los múltiplos de i
                for (j=2*i; j< numeroTamanyoArray; j+=i)
                    esPrimo[j] = false;
            }
        }
    }

    //contamos los primos para el array de primos
    private static int contarPrimos(int numeroTamanyoArray, boolean[] esPrimo) {
        int i;
        int cuenta = 0;
        for (i=0; i< numeroTamanyoArray; i++) {
            if (esPrimo[i])
                cuenta++;
        }
        return cuenta;
    }
    //rellenar array primos
    private static int[] rellenarArrayPrimos(int numeroTamanyoArray, boolean[] esPrimo, int cuenta) {
        int i;
        int j;
        int[] primos = new int[cuenta];
        for (i=0, j=0; i< numeroTamanyoArray; i++) {
            if (esPrimo[i])
                primos[j++] = i;
        }
        return primos;
    }
    //algoritmo para seleccionar los primos
    public static int[] generarPrimos (int numeroMaximo)
    {
        int i;
        if (numeroMaximo >= 2) {
            // Declaraciones
            int numeroTamanyoArray = numeroMaximo + 1; // Tamaño del array
            boolean[] esPrimo = new boolean[numeroTamanyoArray];
            // Inicializar el array
            for (i=0; i<numeroTamanyoArray; i++)
                esPrimo[i] = true;
            // Eliminar el 0 y el 1, que no son primos
            esPrimo[0] = esPrimo[1] = false;
            criba(numeroTamanyoArray, esPrimo);
            int cuenta = contarPrimos(numeroTamanyoArray, esPrimo);
            return rellenarArrayPrimos(numeroTamanyoArray, esPrimo, cuenta);
        } else { // max < 2
            return new int[0];
            // Vector vacío
        }
    }


    // imprimimos el conjunto de primos
        public static void main(String[] args) {
            int numeroMaximo = introducirNumeroMaximo();
            int[] vectorDePrimos;
            vectorDePrimos=generarPrimos(numeroMaximo);
            System.out.println("\nVector de primos hasta:"+numeroMaximo);
            for (int i = 0; i < vectorDePrimos.length; i++) {
                if (i%10==0) System.out.println();
                System.out.print(vectorDePrimos[i]+"\t");
            }
        }

}

