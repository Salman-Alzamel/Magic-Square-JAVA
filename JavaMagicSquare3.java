import java.util.*;

public class JavaMagicSquare3 {
  public static void main(String[] args) {

     /* Generationg a random Magic Square */
    Scanner Sc = new Scanner(System.in);
    System.out.println("Enter 3 or 5 to make a MAGIC SQUARE:");

    int n = Sc.nextInt();

    int magicSquare = n * (n * n + 1) / 2;

    System.out.println("Magic Number = " + magicSquare);

    int[][] square = new int[n][n];

    int squareMid = (int) Math.floor((double) square.length / 2);

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int randomNum = (int) ((Math.random() * 101) % magicSquare);
        square[i][j] = randomNum;
      }
    }

    System.out.println("|*---- Random Square ----*|");
    for (int[] row : square)
      System.out.println(Arrays.toString(row));

    System.out.println();

    /* Sloving the random Magic Square */

    int midealInt = square[squareMid][squareMid];

    int remainingSum = magicSquare - midealInt;

    int horizontalRemSum = remainingSum;

    int verticalRemSum = remainingSum;

    int desendingDiagonalRemSum = remainingSum;

    int asendingDiagonalRemSum = remainingSum;

    for (int i = 0; i < square.length; i++) {
      if (i != squareMid) {
        if (i != (square.length - 1)) {
          square[squareMid][i] = (int) (((Math.random() * 101) % horizontalRemSum));
          horizontalRemSum = horizontalRemSum - square[squareMid][i];

          square[i][squareMid] = (int) (((Math.random() * 101) % verticalRemSum));
          verticalRemSum = verticalRemSum - square[i][squareMid];

          square[i][i] = (int) (((Math.random() * 101) % desendingDiagonalRemSum));
          desendingDiagonalRemSum = desendingDiagonalRemSum - square[i][i];

          square[i][(square.length - 1) - i] = (int) (((Math.random() * 101) % asendingDiagonalRemSum));
          asendingDiagonalRemSum = asendingDiagonalRemSum - square[i][(square.length - 1) - i];

        } else {
          square[squareMid][i] = horizontalRemSum;

          square[i][squareMid] = verticalRemSum;

          square[i][i] = desendingDiagonalRemSum;

          square[i][(square.length - 1) - i] = asendingDiagonalRemSum;

        }

      }
    }
    System.out.println("|*---- Final square ----*|");
    for (int[] row : square)
      System.out.println(Arrays.toString(row));

  }
}