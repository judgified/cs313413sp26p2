Project 2: List Performance - README
====================================

Answers to questions embedded in the code
-----------------------------------------

1. TestList.java / TestIterator.java: "Also try with a LinkedList - does it make any difference?"
   No behavioral difference. Both ArrayList and LinkedList implement the List interface, so
   the same operations (add, remove, get, contains, etc.) produce the same results. You can
   switch to LinkedList by using "list = new LinkedList<Integer>();" in setUp() and commenting
   out the ArrayList line; the tests should still pass.

2. TestList.java: "What does list.remove(5) do?"
   list.remove(5) removes the element at INDEX 5 (the 6th element). It is the overload that
   takes an int, so it treats 5 as a position, not the value 5. The element at that index
   is removed and the list size decreases by one.

3. TestList.java: "What does list.remove(Integer.valueOf(5)) do?"
   list.remove(Integer.valueOf(5)) removes the first occurrence of the VALUE 5. It uses the
   overload that takes an Object, so it finds the first element that equals 5 and removes it.
   If there is no such element, the list is unchanged.

4. TestIterator.java: "What happens if you use list.remove(Integer.valueOf(77))?"
   If you call list.remove(Integer.valueOf(77)) inside the loop while iterating, the iterator
   is not notified of the structural change. This causes a ConcurrentModificationException,
   because the iterator's state no longer matches the list. You must use the iterator's
   remove() method (i.remove()) when removing during iteration so the iterator stays valid.

5. TestPerformance.java: Performance conclusions and running times
   ---------------------------------------------------------------
   Run the tests for different values of SIZE (e.g., 10, 100, 1000, 10000) and possibly
   adjust REPS so each test runs in the tens of seconds. Record the runtimes below.

   Example table (replace with your actual runtimes from the test report):

   SIZE=10, REPS=_______
     testLinkedListAddRemove:  _______ ms
     testArrayListAddRemove:   _______ ms
     testLinkedListAccess:    _______ ms
     testArrayListAccess:     _______ ms

   SIZE=100, REPS=_______
     testLinkedListAddRemove:  _______ ms
     testArrayListAddRemove:   _______ ms
     testLinkedListAccess:    _______ ms
     testArrayListAccess:     _______ ms

   SIZE=1000, REPS=_______
     testLinkedListAddRemove:  _______ ms
     testArrayListAddRemove:   _______ ms
     testLinkedListAccess:    _______ ms
     testArrayListAccess:     _______ ms

   (Add more rows for larger SIZE if you ran them.)

   Conclusions:
   - AddRemove at front (index 0): LinkedList is O(1) per add/remove at front, while
     ArrayList is O(n) because it must shift all elements. So LinkedList should be much
     faster for add/remove at front, especially as SIZE increases.
   - Access by index (get(i)): ArrayList is O(1); LinkedList is O(n) because it must
     traverse from the head. So ArrayList should be much faster for access, and the gap
     should grow as SIZE increases.
   Record your own conclusions based on the runtimes you observed.
