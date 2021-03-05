package UCHelper.adt;

// Range is a pair of data of the same type. It is useful for iteration or
// getting the difference between the data. For example, a range of dates.
public class Range<T extends Comparable<T>> {
  private T start;
  private T end;

  public Range(T start, T end) throws Exception {
    this.start = start;
    this.end = end;

    if (!isValid())
      throw new Exception(String.format("Start(%s) cannot be greater than End(%s)", start, end));
  }

  // Return the start of the range
  public T start() {
    return start;
  }

  // Return the end of the range
  public T end() {
    return end;
  }

  // Check if the rnage is valid
  private boolean isValid() {
    // If start is greater or equal to end then it's invalid
    return !(start.compareTo(end) >= 0);
  }

  // public T difference() {
  // return end - start;
  // }
}
