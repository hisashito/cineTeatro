public class Cinema {
    public static void main(String[] args) {
        int rows = 7;
        int cols = 8;
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
}
