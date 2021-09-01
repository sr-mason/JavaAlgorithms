package academy.kovalevskyi.algorithms.week1.day1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import org.junit.jupiter.api.Test;

class XoHelperTest {

  @Test
  void generateEndStates() {
    Set<XoBoard> set = XoHelper.generateEndStates();
    System.out.println(set.size());
    System.out.println(set);
  }
}