COMP 313/413 Project 2 Report Template
======================================

TestList.java and TestIterator.java
-----------------------------------

	TODO also try with a LinkedList - does it make any difference?

		No. There is no behavioral difference. Both ArrayList and LinkedList
		implement the List interface, so the same operations (add, remove, get,
		contains, etc.) produce the same results. The tests pass with either
		type. You can switch by using list = new LinkedList<Integer>(); in
		setUp() and commenting out the ArrayList line.

TestList.java
-------------

	testRemoveObject()

		list.remove(5); // what does this method do?

			It removes the element at index 5 (the 6th element). The method
			overload that takes an int treats the argument as a position, not
			a value. So the element at that index is removed and the list
			size decreases by one.

		list.remove(Integer.valueOf(5)); // what does this one do?

			It removes the first occurrence of the value 5. This is the
			overload that takes an Object, so it finds the first element
			that equals 5 and removes it. If no such element exists, the
			list is unchanged.

TestIterator.java
-----------------

	testRemove()

		i.remove(); // what happens if you use list.remove(77)?

			If you use list.remove(Integer.valueOf(77)) (or list.remove(77)
			if 77 were an index) instead of i.remove() while iterating, the
			iterator is not notified of the change. That causes a
			ConcurrentModificationException, because the list was modified
			outside the iterator. You must use the iterator's remove()
			method (i.remove()) when removing during iteration so the
			iterator stays consistent with the list.

TestPerformance.java
--------------------

	State how many times the tests were executed for each SIZE (10, 100, 1000 and 10000)
	to get the running time in milliseconds and how the test running times were recorded.
	These are examples of SIZEs you might choose, you can choose others if you wish.

	Each test was run once per SIZE. Running times in milliseconds were printed
	by the test code when running TestPerformance (e.g. ./gradlew test --tests
	"cs271.lab.list.TestPerformance" or Run 'TestPerformance' in IntelliJ).

	SIZE 10
	REPS used: 100000
	                                  #1
        testArrayListAddRemove:        5 ms
        testLinkedListAddRemove:       5 ms
		testArrayListAccess:           2 ms
        testLinkedListAccess:          3 ms

	SIZE 100
	REPS used: 100000
	                                  #1
        testArrayListAddRemove:        6 ms
        testLinkedListAddRemove:       6 ms
		testArrayListAccess:           3 ms
        testLinkedListAccess:          5 ms

	SIZE 1000
	REPS used: 100000
	                                  #1
        testArrayListAddRemove:       18 ms
        testLinkedListAddRemove:       4 ms
		testArrayListAccess:           2 ms
        testLinkedListAccess:         38 ms

	SIZE 10000
	REPS used: 100000
	                                  #1
        testArrayListAddRemove:      151 ms
        testLinkedListAddRemove:      5 ms
		testArrayListAccess:           2 ms
        testLinkedListAccess:       459 ms

	listAccess - which type of List is better to use, and why?

		ArrayList is better for access by index (get(i)). ArrayList stores
		elements in an array, so get(i) is O(1). LinkedList must traverse
		from the head (or tail) to reach index i, so get(i) is O(n). Your
		recorded times should show ArrayListAccess much faster than
		LinkedListAccess, especially as SIZE increases.

	listAddRemove - which type of List is better to use, and why?

		LinkedList is better for add/remove at the front (index 0).
		LinkedList can add or remove at the head in O(1) by changing a few
		links. ArrayList must shift all elements when inserting or removing
		at index 0, so each operation is O(n). Your recorded times should
		show LinkedListAddRemove much faster than ArrayListAddRemove,
		especially as SIZE increases.
