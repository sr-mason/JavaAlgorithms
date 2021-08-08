package Week0.Day0;

import java.util.Arrays;
import java.util.Comparator;

public interface Sort {
    default <T extends Comparable<? super T>> void sort(final T[] target) {
        sort(target, T::compareTo);
    }

    default <T> void sort(final T[] target, final Comparator<T> comparator) {
        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length - i - 1; j++) {
                if (comparator.compare(target[j], target[j + 1]) > 0) {
                    T temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
    }

    default <T> T[] createSortedArray(final T[] target, final Comparator<T> comparator) {
        T[] temp = Arrays.copyOf(target, target.length);
        sort(temp, comparator);
        return temp;
    }

    default String complexityBest() {
        return "N";
    }

    default String complexityAverage() {
        return "N^2";
    }

    default String complexityWorst() {
        return "N^2";
    }

    default String spaceComplexityWorst() {
        return "N";
    }
}