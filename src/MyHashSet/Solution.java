package MyHashSet;

import java.util.List;

import java.util.ArrayList;

class MyHashSet {
  List<List<Integer>> buckets = new ArrayList<List<Integer>>(997); 
  /** Initialize your data structure here. */
  public MyHashSet() {
    for (int i = 0;i < 997;i++) {
      buckets.add(new ArrayList<Integer>());
    }
  }
  
  public void add(int key) {
    if (!this.contains(key)) {
      int i = key % 997;
      buckets.get(i).add(key);
    }
  }
  
  public void remove(int key) {
    if (this.contains(key)) {
      int i = key % 997;
      List<Integer> bucket = buckets.get(i);
      bucket.remove(bucket.indexOf(key));
    }
  }
  
  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int i = key % 997;
    return buckets.get(i).contains(key);
  }
}

/**
* Your MyHashSet object will be instantiated and called as such:
* MyHashSet obj = new MyHashSet();
* obj.add(key);
* obj.remove(key);
* boolean param_3 = obj.contains(key);
*/