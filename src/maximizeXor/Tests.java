package maximizeXor;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;

class Suite {
  int[] nums;
  int[][] queries;
  int[] ret;

  Suite(int[] nums, int[][] queries, int[] ret) {
    this.nums = nums;
    this.queries = queries;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = new Suite[] {
        new Suite(new int[] { 0, 1, 2, 3, 4 }, new int[][] { { 3, 1 }, { 1, 3 }, { 5, 6 } }, new int[] { 3, 3, 7 }),
        new Suite(new int[] { 5, 2, 4, 6, 6, 3 }, new int[][] { { 12, 4 }, { 8, 1 }, { 6, 3 } },
            new int[] { 15, -1, 5 }),
        new Suite(
            new int[] { 760625198, 15138539, 61033, 267654046, 133000577, 229497, 155443, 109330, 13340119, 8260519,
                981126373, 441631490, 498767021, 171522247, 503991705, 11276686, 176397, 23247190, 472734721,
                243117401 },
            new int[][] { { 383815038, 1000000000 }, { 4194304, 1000000000 }, { 633072806, 981082380 },
                { 875344070, 965383924 }, { 31380566, 64633365 }, { 4194304, 91884 }, { 4194304, 158853440 },
                { 10839453, 224610550 }, { 4194304, 349538162 }, { 171815678, 403214196 }, { 15355179, 1000000000 },
                { 938931463, 441640682 }, { 23207682, 1000000000 }, { 4194304, 1000000000 }, { 75686235, 1000000000 },
                { 86208917, 259012 }, { 905942425, 1000000000 }, { 692399970, 1000000000 }, { 22418605, 1000000000 },
                { 369403291, 1000000000 } },
            new int[] { 1001829712, 976932069, 1072246692, 1041598465, 31424324, 4255337, 128806273, 178019674,
                263459742, 231792511, 982548942, 1037028800, 991482855, 976932069, 1056452030, 86220796, 1069985118,
                927949563, 992794696, 995270069 }) };

    Solution s = new Solution();
    for (Suite su : suites) {
      assertArrayEquals(su.ret, s.maximizeXor(su.nums, su.queries));
    }
  }
}
