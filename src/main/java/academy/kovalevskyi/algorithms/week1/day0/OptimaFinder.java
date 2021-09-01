package academy.kovalevskyi.algorithms.week1.day0;

import java.util.function.Function;

public class OptimaFinder {

  public static double findOptima(Function<Double, Double> f, double start, double end,
      double precision) {
    double mid = 0.0;
    while (start <= end) {
      mid = (start + end) / 2;
      double prev = f.apply(mid - precision);
      double current = f.apply(mid);
      double next = f.apply(mid + precision);
      if (current < next && current < prev) {
        return mid;
      }
      if (current > next) {
        start = mid + precision;
      } else {
        end = mid - precision;
      }
    }
    return mid;
  }
}
