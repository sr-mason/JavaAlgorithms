package academy.kovalevskyi.algorithms.week1.day1;

import java.util.Arrays;

public class XoBoard {

  private final XoFigure[][] array;

  public XoBoard() {
    this.array = new XoFigure[3][3];
  }

  public XoBoard(XoBoard copy) {
    this.array = new XoFigure[3][3];
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        this.array[i][j] = copy.array[i][j];
      }
    }
  }

  public XoBoard(XoFigure[][] array) {
    this.array = array;
  }

  public XoFigure getFigure(int x, int y) {
    return (check(x, y)) ? array[x][y] : null;
  }

  public void setFigure(int x, int y, XoFigure figure) {
    if (check(x, y)) {
      this.array[x][y] = figure;
    }
  }

  public XoFigure hasWinner() {
    /*if (!checkCountFigure()) {
      throw new RuntimeException("chit");
    }*/
    // 1st diagonal
    if (array[0][0] != null && array[0][0].equals(array[1][1]) && array[0][0].equals(array[2][2])) {
      return array[0][0];
    }
    //2st diagonal
    if (array[0][2] != null && array[0][2].equals(array[1][1]) && array[0][2].equals(array[2][0])) {
      return array[0][2];
    }
    //1st column
    if (array[0][0] != null && array[0][0].equals(array[1][0]) && array[0][0].equals(array[2][0])) {
      return array[0][0];
    }
    // 2st column
    if (array[0][1] != null && array[0][1].equals(array[1][1]) && array[0][1].equals(array[2][1])) {
      return array[0][1];
    }
    //3d column
    if (array[0][2] != null && array[0][2].equals(array[1][2]) && array[0][2].equals(array[2][2])) {
      return array[0][2];
    }
    // 1st row
    if (array[0][0] != null && array[0][0].equals(array[0][1]) && array[0][0].equals(array[0][2])) {
      return array[0][0];
    }
    // 2st row
    if (array[1][0] != null && array[1][0].equals(array[1][1]) && array[1][0].equals(array[1][2])) {
      return array[1][0];
    }
    // 3d row
    if (array[2][0] != null && array[2][0].equals(array[2][1]) && array[2][0].equals(array[2][2])) {
      return array[2][0];
    }
    return null;
  }

  private boolean checkCountFigure() {
    int countX = 0;
    int countO = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        if (array[i][j] != null && array[i][j].equals(XoFigure.figureX)) {
          countX++;
        }
        if (array[i][j] != null && array[i][j].equals(XoFigure.figureO)) {
          countO++;
        }
      }
    }
    return countX - countO == 1 || countO == countX;
  }

  public boolean tie() {
    return hasWinner() != null;
  }

  public boolean check(int x, int y) {
    return (x >= 0 & x < 3) || (y >= 0 & y < 3);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    XoBoard xoBoard = (XoBoard) o;
    return Arrays.deepEquals(array, xoBoard.array);
  }

  @Override
  public int hashCode() {
    return Arrays.deepHashCode(array);
  }

  @Override
  public String toString() {
    return "array=" + Arrays.deepToString(array) + '}';
  }
}