package romanToInt;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


class Suite {
  String s;
  int ret;
  Suite(String s, int ret) {
    this.s = s;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite("III", 3),
      new Suite("IV", 4),
      new Suite("IX", 9),
      new Suite("LVIII", 58),
      new Suite("MCMXCIV", 1994)
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.romanToInt(su.s));
    }
  }
}
