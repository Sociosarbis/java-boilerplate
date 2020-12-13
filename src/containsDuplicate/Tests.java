package containsDuplicate;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests {
  @Test
  public void testResults() throws Exception {
    Solution s = new Solution();
    assertEquals(s.containsDuplicate(new int[]{1, 2, 3, 1}), true);
    assertEquals(s.containsDuplicate(new int[]{1, 2, 3, 4}), false);
    assertEquals(s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}), true);
  }
}
