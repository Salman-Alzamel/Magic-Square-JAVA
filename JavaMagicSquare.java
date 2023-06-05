import java.util.*;
import java.io.*;

public class JavaMagicSquare {
  static boolean checkMagicSquare(int[][] square, int magicConst) {
    int squareLength = square.length;
    int squareMid = (int) Math.floor((double) square.length / 2);

    boolean checkMagicSum = true;

    int horizontal = 0;

    int vertical = 0;

    int desendingDiagonal = 0;

    int asendingDiagonal = 0;

    for (int i = 0; i < squareLength; i++) {
      horizontal = +square[squareMid][i];
      vertical = +square[i][squareMid];
      desendingDiagonal = +square[i][i];
      asendingDiagonal = +square[i][(squareLength - 1) - i];
    }

    if (horizontal != magicConst)
      checkMagicSum = false;
    if (vertical != magicConst)
      checkMagicSum = false;
    if (desendingDiagonal != magicConst)
      checkMagicSum = false;
    if (asendingDiagonal != magicConst)
      checkMagicSum = false;

    return checkMagicSum;
  }

  public static void main(String[] args) {

    Scanner Sc = new Scanner(System.in);
    System.out.println("Enter 3 or 5 to make a MAGIC SQUARE:");

    int n = Sc.nextInt();

    int magicSquare = n * (n * n + 1) / 2;

    System.out.println("Magic Number = " + magicSquare);

    int[][] square;

    if (n == 5) {
      square = new int[5][5];

      do {
        for (int i = 0; i < 5; i++) {
          for (int j = 0; j < 5; j++) {
            int randomNum = (int) ((Math.random() * 101) % magicSquare);
            square[i][j] = randomNum;
          }
        }

        System.out.println("|*-----------------*|");
        for (int[] row : square)
          System.out.println(Arrays.toString(row));

        System.out.println("|*-----------------*|");
        System.out.println();

      } while (checkMagicSquare(square, magicSquare) == false);

    } else {
      square = new int[3][3];

      do {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            int randomNum = (int) ((Math.random() * 101) % magicSquare);
            square[i][j] = randomNum;
          }
        }

        System.out.println("|*-----------*|");
        for (int[] row : square)
          System.out.println(Arrays.toString(row));

        System.out.println("|*-----------*|");
        System.out.println();

      } while (checkMagicSquare(square, magicSquare) == false);
    }

    System.out.println("Final square");
    for (int[] row : square)
      System.out.println(Arrays.toString(row));

  }
}