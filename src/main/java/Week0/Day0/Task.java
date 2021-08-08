package Week0.Day0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task {
    public static boolean sameCharactersSorting(String left, String right) {
        char[] leftArray = left.toCharArray();
        Arrays.sort(leftArray);
        char[] rightArray = right.toCharArray();
        Arrays.sort(rightArray);
        return Arrays.equals(leftArray, rightArray);
    }

    public static boolean sameCharactersO1(String left, String right) {
        if (left.length() != right.length()) return false;
        List<Character> listLeft = new ArrayList<>();
        for (Character s: left.toCharArray()) {
            listLeft.add(s);
        }
        List<Character> rightLeft = new ArrayList<>();
        for (Character s: right.toCharArray()) {
            listLeft.add(s);
        }
        for (Character character : listLeft) {
            rightLeft.remove(character);
        }
        return rightLeft.size() == 0;
    }

}
