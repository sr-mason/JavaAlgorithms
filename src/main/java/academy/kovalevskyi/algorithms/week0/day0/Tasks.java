package academy.kovalevskyi.algorithms.week0.day0;

import java.util.ArrayList;
import java.util.List;

public class Tasks {

  public static boolean sameCharactersSorting(String left, String right) {
    if (left.length() != right.length()) {
      return false;
    }
    Sort sort = new Sort() {
    };
    Character[] leftArray = left.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    sort.sort(leftArray);
    Character[] rightArray = right.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
    sort.sort(rightArray);
    for (int i = 0; i < leftArray.length; i++) {
      if (leftArray[i] != rightArray[i]) {
        return false;
      }
    }
    return true;
  }

  /*public static boolean sameCharactersO1(String left, String right) {
    if (left.length() != right.length()) {
      return false;
    }
    List<Character> listLeft = new ArrayList<>();
    for (Character s : left.toCharArray()) {
      listLeft.add(s);
    }
    List<Character> rightLeft = new ArrayList<>();
    for (Character s : right.toCharArray()) {
      listLeft.add(s);
    }
    for (Character character : listLeft) {
      rightLeft.remove(character);
    }
    return rightLeft.isEmpty();
  }*/

  public static boolean sameCharactersO1(String left, String right) {
    if (left.length() != right.length()) {
      return false;
    }

    char[] leftArray = new char[256];

    for (int i = 0; i < left.length(); i++) {
      leftArray[left.charAt(i)]++;
    }

    for (int i = 0; i < right.length(); i++) {
      leftArray[right.charAt(i)]--;
      if (leftArray[right.charAt(i)] < 0) {
        return false;
      }
    }
    return true;
  }
}