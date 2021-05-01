package getImportance;

import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;


class Employee {
  public int id;
  public int importance;
  public List<Integer> subordinates;
  Employee(int id, int importance, List<Integer> subordinates) {
    this.id = id;
    this.importance = importance;
    this.subordinates = subordinates;
  }
};


class Solution {
  public int getImportance(List<Employee> employees, int id) {
    Set<Integer> visited = new HashSet<Integer>();
    Map<Integer, Integer> idToIndex = new HashMap<Integer, Integer>();
    for (int i = 0;i < employees.size();i++) {
      int employeeId = employees.get(i).id;
      idToIndex.put(employeeId, i);
    }
    List<Integer> bfs = new ArrayList<Integer>();
    bfs.add(id);
    visited.add(id);
    int ret = 0;
    while (!bfs.isEmpty()) {
      int cur = bfs.remove(bfs.size() - 1);
      Employee employee = employees.get(idToIndex.get(cur));
      ret += employee.importance;
      for (int sub: employee.subordinates) {
        if (!visited.contains(sub)) {
          bfs.add(sub);
          visited.add(sub);
        }
      }
    }
    return ret;
  }
}