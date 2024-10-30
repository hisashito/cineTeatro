/*
Leer dos números enteros positivos que representen el número de filas y el número de asientos por fila.
Imprimir el arreglo de asientos según el formato establecido en la etapa anterior.
Leer dos números enteros que representen el número de fila y el número de asiento seleccionados.
Determinar el precio del boleto basado en las reglas previamente establecidas:
10 dólares si el total de asientos es 60 o menos.
10 dólares para la mitad frontal de las filas y 8 dólares para la mitad trasera en salas más grandes.
Imprimir todos los asientos en la sala de cine, marcando el asiento elegido con el símbolo "B".
Mostrar el precio del boleto y detener el programa.
*/

public class Cinema {

    static int price1 = 10;
    static int price2 = 8;
    static int nSeats = 60;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int rows = 7;
        int cols = 8;
        rows = askForInt("Enter the number of rows:");
        cols = askForInt("Enter the number of seats in each row:");
        displaySeats(rows, cols, -1, -1, false);
        int seatRow = askForInt("Enter a row number:");
        int seatCol = askForInt("Enter a seat number in that row:");
        int price = checkPrice(rows, cols, seatRow);
        System.out.println("Ticket price: $%d ".formatted(price));
        displaySeats(rows, cols, seatRow, seatCol, true);
   }
    
    public static void displaySeats (int rows, int cols, int row, int col, boolean book) {
        String seat = "S";
        //String row = seat.repeat(cols);
        System.out.println("Cinema:");    
        String toPrint = " ";
            for (int i = 0 ; i < rows + 1; i++) {
                for (int j = 0; j < cols + 1; j++) {
                    if (i == 0 && j > 0) {
                        toPrint = j + " "; 
                    } else if (i > 0 && j == 0) {
                        toPrint = i + " "; 
                    } else if ( i > 0 && j > 0) {
                        toPrint = (book && i == row && j == col) ? "B ":seat + " "; 
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
        if (seats > 60){
            return cols * ((rows / 2) * (price1 - price2) + rows * price2);
        }
        return seats * price1;
    }
    
    public static int askForInt(String in){
        System.out.println(in);
        return sc.nextInt();
    }

    public static int checkPrice(int rows, int cols, int row) {
        return hasManySeats(rows *  cols) &&  row > rows / 2 ? price2 : price1;                    
    }

    public static boolean hasManySeats(int seats){
        return seats > nSeats;
    }
}
