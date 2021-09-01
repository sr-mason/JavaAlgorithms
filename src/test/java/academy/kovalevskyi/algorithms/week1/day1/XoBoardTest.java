package academy.kovalevskyi.algorithms.week1.day1;

import static academy.kovalevskyi.algorithms.week1.day1.XoFigure.figureO;
import static academy.kovalevskyi.algorithms.week1.day1.XoFigure.figureX;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class XoBoardTest {

  @Test
  void hasWinner() {
    XoFigure[][] test = {
        {figureX, figureO, null},
        {null, figureX, figureO},
        {null, figureO, figureX}};
    XoBoard xoBoard = new XoBoard(test);
    System.out.println(xoBoard.hasWinner());
  }
}