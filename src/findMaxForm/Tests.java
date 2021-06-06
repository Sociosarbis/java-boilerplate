package findMaxForm;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


class Suite {
  String[] strs;
  int m;
  int n;
  int ret;
  public Suite(String[] strs, int m, int n, int ret) {
    this.strs = strs;
    this.m = m;
    this.n = n;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      /*new Suite(
        new String[]{ "10","0001","111001","1","0" },
        5,
        3,
        4
      ),
      new Suite(
        new String[]{ "10","0","1" },
        1,
        1,
        2
      ),*/
      /*new Suite(
        new String[]{ "10","0001","111001","1","0"},
        4,
        3,
        3
      ),*/
      new Suite(
        new String[]{"10","1","0"},
        1,
        1,
        2)
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.findMaxForm(su.strs, su.m, su.n));
    }
  }
}
