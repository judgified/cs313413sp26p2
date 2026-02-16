package cs271.lab.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPerformance {

  // TODO run test and record running times for SIZE = 10, 100, 1000, 10000, ...
  // (choose in conjunction with REPS below up to an upper limit where the clock
  // running time is in the tens of seconds)
  // TODO Question: What conclusions can you draw about the performance of LinkedList vs. ArrayList when
  // comparing their running times for AddRemove vs. Access? Record those running times in README.txt!
  // TODO (optional) refactor to DRY
  // which of the two lists performs better as the size increases?
  private final int SIZE = 10000;

  // TODO choose this value in such a way that you can observe an actual effect
  // for increasing problem sizes (e.g. use smaller REPS for larger SIZE so tests stay in tens of seconds)
  private final int REPS = 100000;

  private List<Integer> arrayList;

  private List<Integer> linkedList;

  @Before
  public void setUp() throws Exception {
    arrayList = new ArrayList<Integer>(SIZE);
    linkedList = new LinkedList<Integer>();
    for (var i = 0; i < SIZE; i++) {
      arrayList.add(i);
      linkedList.add(i);
    }
  }

  @After
  public void tearDown() throws Exception {
    arrayList = null;
    linkedList = null;
  }

  @Test
  public void testLinkedListAddRemove() {
    long start = System.currentTimeMillis();
    for (var r = 0; r < REPS; r++) {
      linkedList.add(0, 77);
      linkedList.remove(0);
    }
    long ms = System.currentTimeMillis() - start;
    System.out.println("testLinkedListAddRemove (SIZE=" + SIZE + ", REPS=" + REPS + "): " + ms + " ms");
  }

  @Test
  public void testArrayListAddRemove() {
    long start = System.currentTimeMillis();
    for (var r = 0; r < REPS; r++) {
      arrayList.add(0, 77);
      arrayList.remove(0);
    }
    long ms = System.currentTimeMillis() - start;
    System.out.println("testArrayListAddRemove (SIZE=" + SIZE + ", REPS=" + REPS + "): " + ms + " ms");
  }

  @Test
  public void testLinkedListAccess() {
    long start = System.currentTimeMillis();
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += linkedList.get(r % SIZE);
    }
    long ms = System.currentTimeMillis() - start;
    System.out.println("testLinkedListAccess (SIZE=" + SIZE + ", REPS=" + REPS + "): " + ms + " ms");
  }

  @Test
  public void testArrayListAccess() {
    long start = System.currentTimeMillis();
    var sum = 0L;
    for (var r = 0; r < REPS; r++) {
      sum += arrayList.get(r % SIZE);
    }
    long ms = System.currentTimeMillis() - start;
    System.out.println("testArrayListAccess (SIZE=" + SIZE + ", REPS=" + REPS + "): " + ms + " ms");
  }
}
