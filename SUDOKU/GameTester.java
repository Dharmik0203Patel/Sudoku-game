import java.util.Scanner;

public class GameTester {
     public static void main(String args[]) {

          SudokuGame i = new SudokuGame("start");
          i.printMySudokuGame();
          Scanner guess = new Scanner(System.in);
          {
               int row, col, val;
               String action;
               while (true) {
                    System.out.println("Enter I for insert or R for remove: ");
                    action = guess.next();

                    System.out.println("Row: ");
                    row = guess.nextInt();
                    System.out.println("Column: ");
                    col = guess.nextInt();

                    if (action.equals("I")) {
                         System.out.println("Value: ");     
                         val = guess.nextInt();
                         if (i.insertVal(row, col, val)) {
                              i.printMySudokuGame();
                              System.out.println("The Number is Inserted Sucessfully");
                         } else {
                              i.printMySudokuGame();
                              System.out.println("Try Again, Number you have entered is already present");
                         }
                    } else {
                         i.removeVal(row, col);
                         i.printMySudokuGame();
                         System.out.println("The Number is removed Sucessfully");
                    }
                    //guess.close();
               }
          }
     }
}