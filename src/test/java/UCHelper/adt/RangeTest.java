package UCHelper.adt;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class RangeTest {

  final static SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
  static Date startDate;
  static Date endDate;

  @BeforeAll
  static void setup() {
    try {
      startDate = sdf.parse("03/05/2021");
      endDate = sdf.parse("03/06/2021");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testConstructRange() {
    // Range will throw an exception if the start is greater than end
    assertThrows(Exception.class, () -> {
      Range<Date> range = new Range<>(endDate, startDate);
    });
  }

  @Test
  public void testStart() {
    try {
      Range<Date> range = new Range<>(startDate, endDate);
      assertEquals(range.start(), startDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testEnd() {
    try {
      Range<Date> range = new Range<>(startDate, endDate);
      assertEquals(range.end(), endDate);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}