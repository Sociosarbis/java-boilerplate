package MyHashSet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Suite {
  String[] methods;
  int[] args;
  Boolean[] rets;

  Suite(String[] methods, int[] args, Boolean[] rets) {
    this.methods = methods;
    this.args = args;
    this.rets = rets;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite suite = new Suite(
      new String[]{
        "add", "add", "contains", "contains", "add", "contains", "remove", "contains"
      },
      new int [] {
        1, 2, 1, 3, 2, 2, 2, 2
      },
      new Boolean[] {
        null, null, true, false, null, true, null, false
      }
    );

    MyHashSet set = new MyHashSet();
    for (int i = 0;i < suite.methods.length;i++) {
      switch (suite.methods[i]) {
        case "add":
          set.add(suite.args[i]);
          break;
        case "remove":
          set.remove(suite.args[i]);
          break;
        default:
          assertEquals(suite.rets[i], set.contains(suite.args[i]));
      }
    }
  }
}