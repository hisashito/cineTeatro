/*
El programa debe iniciar leyendo dos números enteros positivos que representan 
el número de filas y asientos por fila. 

Luego, mostrará un menú con tres opciones.
Mostrar asientos: 
Imprime el arreglo de asientos, marcando los asientos vacíos con "S" y los ocupados con "B".
Comprar un boleto: 
Lee las coordenadas del asiento, imprime el precio del boleto y marca el asiento como "B" cuando se elija 
la opción Mostrar asientos.
Salir: Detiene el programa.
*/


import java.util.Scanner;

public class Cinema {
    static int price1 = 10;
    static int price2 = 8;
    static int nSeats = 60;
    static boolean[][] seats;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = 7;
        int cols = 8;
        rows = askForInt("Enter the number of rows:");
        cols = askForInt("Enter the number of seats in each row:");
        setCinema(rows, cols);
        while (true) {
            int option = menu();
            switch (option) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    int seatRow = askForInt("Enter a row number:");
                    int seatCol = askForInt("Enter a seat number in that row:");
                    int price = checkPrice(rows, cols, seatRow);
                    System.out.println("Ticket price: $%d ".formatted(price));
                    buyTicket(seatRow, seatCol);
                    break;
                case 0:
                    return;
                default:
                    break;
            }
        }
    }
    
    public static void setCinema(int rows, int cols) {
        seats = new boolean[rows][cols];
    }
    
    public static void buyTicket(int row, int col) {
        boolean isAvailable = !seats[row - 1][col - 1];
        if (isAvailable) {
            seats[row - 1][col - 1] = true;
        } else {
            System.out.println("Seat not available");
        }
    }
    public static int menu() {
        String show = "Show the seats";
        String buy = "Buy a ticket";
        String exit = "Exit";
        int userOption = askForInt("1. %s %n2. %s %n0. %s".formatted(show, buy, exit));
        return userOption;
    }
    public static int calculateTotalIncome(int rows, int cols) {
        int seats = rows * cols;
        if (seats > 60) {
            return cols * ((rows / 2) * (price1 - price2) + rows * price2);
        }
        return seats * price1;
    }

    public static int askForInt(String in) {
        System.out.println(in);
        return sc.nextInt();
    }

    public static int checkPrice(int rows, int cols, int row) {
        return hasManySeats(rows * cols) && row > rows / 2 ? price2 : price1;
    }

    public static boolean hasManySeats(int seats) {
        return seats > nSeats;
    }
     
    public static void showSeats() {
        String available = "S";
        String reserved = "B";
        System.out.println("Cinema:");
        String toPrint = "";
        for (int k = 0; k < seats[0].length + 1; k++) {
             toPrint = k > 0 ? "%d ".formatted(k): "  ";
             System.out.print(toPrint);
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                String aSeat = !seats[i][j] ? available : reserved;
                toPrint = j > 0 ? "%s ".formatted(aSeat) : "%d %s ".formatted(i + 1, aSeat);
                System.out.print(toPrint);
            }
            System.out.println();
        }
    }
}
