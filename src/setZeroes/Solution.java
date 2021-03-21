package setZeroes;

public class Solution {
  public void setZeroes(int[][] matrix) {
    boolean[] firstCellZero = {false, false};
    for (int i = 0;i < matrix.length;i++) {
      int[] row = matrix[i];
      for (int j = 0;j < matrix[i].length;j++) {
        if (row[j] == 0) {
          if (i == 0 && !firstCellZero[1]) {
            firstCellZero[1] = true;
          }

          if (j == 0 && !firstCellZero[0]) {
            firstCellZero[0] = true;
          }

          if (row[0] != 0) {
            row[0] = 0;
          }
          if (matrix[0][j] != 0) {
            matrix[0][j] = 0;
          }
        }
      }
    }

    for (int i = 1;i < matrix.length;i++) {
      int[] row = matrix[i];
      for (int j = 1;j < matrix[i].length;j++) {
        if ((row[0] == 0 || matrix[0][j] == 0) && row[j] != 0) {
          row[j] = 0;
        }
      }
    }

    if (firstCellZero[0] == true) {
      for (int i = 1;i < matrix.length;i++) {
        if (matrix[i][0] != 0) {
          matrix[i][0] = 0;
        }
      }
    }

    if (firstCellZero[1] == true) {
      for (int i = 1;i < matrix[0].length;i++) {
        if (matrix[0][i] != 0) {
          matrix[0][i] = 0;
        }
      }
    }
  }
}
