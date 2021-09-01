package academy.kovalevskyi.algorithms.week1.day2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PercolationTest {

  @Test
  void generateGraph2x2() {
    boolean[][] array = { { true, true},
                        { true, true }};
    Percolation percolation = new Percolation(array);
    System.out.println(percolation.percolate());
  }
  @Test
  void generateGraph3x3() {
    boolean[][] array = { { true, true, true},
                        { true, true, true },
                        { true, true, true }};
    Percolation percolation = new Percolation(array);
    System.out.println(percolation.percolate());
  }
  @Test
  void generateGraph4x4() {
    boolean[][] array = { { true, true, true, true},
                        { true, true, true, true },
                        { true, true, true, true },
                        { true, true, true, true }};
    Percolation percolation = new Percolation(array);
    System.out.println(percolation.percolate());
  }

  @Test
  void generateGraph3x3false() {
    boolean[][] array = {
        {true, true, false},
        {false, true, false},
        {false, true, true}};
    Percolation percolation = new Percolation(array);
    System.out.println(percolation.percolate());
  }
}