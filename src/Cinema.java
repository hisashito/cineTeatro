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
