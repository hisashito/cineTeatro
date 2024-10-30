/*
Cuando se elige la opción Estadísticas, el programa debe mostrar:

Número de boletos comprados.
Porcentaje de boletos comprados, redondeado a 2 decimales.
Ingresos actuales.
Ingresos totales si se vendieran todos los boletos.

Las demás opciones del menú funcionan igual, salvo que Comprar un boleto no permite seleccionar un asiento 
ya ocupado. Si el usuario elige un asiento ocupado, imprime "¡Ese boleto ya ha sido comprado!" y solicita 
otras coordenadas. 
Si elige coordenadas fuera de rango, imprime "¡Entrada incorrecta!" y solicita nuevas coordenadas.
*/


import java.util.Scanner;

public class Cinema {
    static int price1 = 10;
    static int price2 = 8;
    static int nSeats = 60;
    
    static int totalIncome;
    static int currentIncome;
    
    static boolean[][] seats;
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
    int rows = 7;
    int cols = 8;
    rows = askForInt("Enter the number of rows:");
    cols = askForInt("Enter the number of seats in each row:");
    setCinema(rows, cols);       
    int option;
    while (true) {
        option = menu();
        switch (option) {
            case 1:
                showSeats();
                break;
            case 2:
                sellTicket(rows, cols);
                break;
            case 3:
                showStatistics();
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
        totalIncome = calculateTotalIncome(rows, cols);
    }
    
    public static void showSeats() {
        String available = "S";
        String reserved = "B";
        System.out.println("Cinema:");
        String toPrint = "";
        for (int k = 0; k < seats[0].length + 1; k++) {
             toPrint = k > 0 ? " %d".formatted(k): " ";
             System.out.print(toPrint);
        }
        System.out.println();
        for (int i = 0; i < seats.length; i++) {
            for (int j = 0; j < seats[0].length; j++) {
                String aSeat = !seats[i][j] ? available : reserved;
                toPrint = j > 0 ? " %s".formatted(aSeat) : "%d %s".formatted(i + 1, aSeat);
                System.out.print(toPrint);
            }
            System.out.println();
        }
    }

    public static int[] askForDesiredSeat(int maxRow, int maxCol) {
        int seatRow;
        int seatCol;
        try {
            seatRow = askForInt("Enter a row number:");
            seatCol = askForInt("Enter a seat number in that row:");    
        } catch (Exception e){
            return new int[0];
        }
        if(seatRow > maxRow || seatCol > maxCol) {
            System.out.println("Wrong input!");
            return new int[0];
        }
        return new int[]{seatRow, seatCol};
    }
                 
    public static boolean buyTicket(int row, int col, int currentPrice) {
        boolean isAvailable = !seats[row - 1][col - 1];
        if (isAvailable) {
            seats[row - 1][col - 1] = true;
            System.out.println("Ticket price: $%d ".formatted(currentPrice));
            currentIncome += currentPrice;
        } else {
            System.out.println("That ticket has already been purchased!");
            return false;
        }
        return true;
    }

    public static void sellTicket(int rows, int cols){
        int currentPrice = 0;
        boolean completed = false;
            while (!completed) {
                int[] clientSelection = askForDesiredSeat(rows, cols);
                if (clientSelection.length == 2) {
                    currentPrice = checkPrice(rows, cols, clientSelection[0]);
                    completed = buyTicket(clientSelection[0], clientSelection[1], currentPrice); //, currentIncome);
                }
            }
    }
    
    public static int menu() {
        System.out.println();
        String show = "Show the seats";
        String buy = "Buy a ticket";
        String exit = "Exit";
        String stats = "Statistics";
        int userOption = askForInt("1. %s %n2. %s %n3. %s %n0. %s".formatted(show, buy, stats, exit));
        return userOption;
    }

    public static int countSoldSeats(){
        int soldCounter = 0;
        for (boolean[] row: seats) {
            for (boolean soldSeat: row) {
                if (soldSeat) {
                    soldCounter++;    
                }
            }
        }
        return soldCounter;
    }
    
    public static void showStatistics() {
        int purseats = countSoldSeats();
        int totalSeats = seats.length * seats[0].length;
        double percentage =   purseats * 100.0 / totalSeats;
        String purchasedTickets = "Number of purchased tickets: %d\n".formatted(purseats);
        String percentOfPT = "\nPercentage: %.2f%%\n".formatted(percentage);
        String currIncome = "Current income: $%d\n".formatted(currentIncome);
        String totIncome = "Total Income: $%d\n".formatted(totalIncome);
        System.out.println(purchasedTickets + percentOfPT + currIncome +totIncome);
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
        return rows * cols > nSeats && row > rows / 2 ? price2 : price1;
    }
}
