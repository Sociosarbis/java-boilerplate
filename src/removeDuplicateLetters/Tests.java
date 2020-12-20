package removeDuplicateLetters;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

class Suite {
  public String s;
  public String ret;
  public Suite(String s, String ret) {
    this.s = s;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() throws Exception {
    Solution s = new Solution();
    Suite suites[] = new Suite[]{
      new Suite("bcabc", "abc"),
      new Suite("cbacdcbc", "acdb"),
      new Suite("bbcaac", "bac"),
      new Suite("edebbed", "bed"),
    };
    for (Suite suite:suites) {
      assertEquals(s.removeDuplicateLetters(suite.s), suite.ret);
    }
  }
}
