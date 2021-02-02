package characterReplacement;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
  String s;
  int k;
  int ret;
  Suite(String s, int k, int ret) {
    this.s = s;
    this.k = k;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Solution s = new Solution();
    Suite[] suites = {
      new Suite(
        "ABAB",
        2,
        4
      ),
      new Suite(
        "AABABBA",
        1,
        4
      )
    };

    for (Suite su: suites) {
      assertEquals(su.ret, s.characterReplacement(su.s, su.k));
    }
  }
}
