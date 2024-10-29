/**
En esta etapa, se deben leer dos números enteros positivos: el número de filas y el número de asientos por fila. 

El precio de los boletos se determina según las siguientes reglas:

Si el total de asientos no supera 60, cada boleto cuesta 10 dólares.
En salas más grandes, los boletos cuestan 10 dólares para la mitad frontal de las filas y 8 dólares para 
la mitad trasera. 
Si el número de filas es impar (por ejemplo, 9), la primera mitad incluye las primeras 4 filas y la segunda 
mitad abarca las 5 filas restantes.
Se debe calcular la ganancia por los boletos vendidos según el número de asientos y mostrar el resultado, 
deteniendo luego el programa. 
El número de filas y asientos no excederá 9.
*/

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int rows = 7;
        int cols = 8;
        rows = askForInt("enter the number of rows:");
        cols = askForInt("Enter the number of seats in each row:");
        System.out.println("Total income:" + System.lineSeparator() + "$" + calculateTotalIncome(rows,cols));
    }

    public static void displaySeats (int rows, int cols) {
        String seat = "S";
        String row = seat.repeat(cols);
        System.out.println("Cinema:");    
        String toPrint = " ";
            for (int i = 0 ; i < rows + 1; i++) {
                for (int j = 0; j < cols + 1; j++) {
                    if (i == 0 && j > 0) {
                        toPrint = j + " "; 
                    } else if (i > 0 && j == 0) {
                        toPrint = i + " "; 
                    } else if ( i > 0 && j > 0) {
                        toPrint = seat + " ";
                    } else if (i == 0 && j == 0) {
                        toPrint = "  ";
                    }
                    System.out.print(toPrint);
                }
                System.out.println();
            }
    }

    public static int calculateTotalIncome (int rows, int cols) {
        int seats = rows * cols;
        int price1 = 10;
        int price2 = 8;
        
        if (seats > 60){
            return cols * ((rows / 2) * (price1 - price2) + rows * price2);
        }
        return seats * price1;
    }
    
    public static int askForInt(String in){
        System.out.println(in);
        return (new Scanner(System.in)).nextInt();
    }
}
