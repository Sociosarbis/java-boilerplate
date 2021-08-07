package getImportance;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

class Suite {
  List<Employee> employees;
  int id;
  int ret;

  Suite(List<Employee> employees, int id, int ret) {
    this.employees = employees;
    this.id = id;
    this.ret = ret;
  }
}

public class Tests {
  @Test
  public void testResults() {
    Suite[] suites = {
      new Suite(Arrays.asList(new Employee(1, 5, Arrays.asList(2, 3)), new Employee(2, 3, Arrays.asList()),new Employee(3, 3, Arrays.asList())), 1, 11)
    };

    Solution s = new Solution();
    for (Suite su: suites) {
      assertEquals(su.ret, s.getImportance(su.employees, su.id));
    }
  }
}
