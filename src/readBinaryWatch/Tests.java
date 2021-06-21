package readBinaryWatch;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;


class Suite {
  int turnedOn;
  List<String> ret;
  Suite(int turnedOn, List<String> ret) {
    this.turnedOn = turnedOn;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[]{
      new Suite(1, List.of("0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00")),
      new Suite(9, List.of())
    };

    Solution s = new Solution();
    for (Suite su:suites) {
      assertEquals(su.ret, s.readBinaryWatch(su.turnedOn));
    }
  }
}
