package smallestGoodBase;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

class Suite {
  String s;
  String ret;
  Suite(String s, String ret) {
    this.s = s;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite("13", "3"),
      new Suite("4681", "8"),
      new Suite("1000000000000000000", "999999999999999999"),
      new Suite("2251799813685247", "2"),
      new Suite("3", "2")
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.smallestGoodBase(su.s));
    }
  }
}
