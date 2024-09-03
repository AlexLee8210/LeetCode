// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {

    Queue<Integer> q;
    Iterator<Integer> it;

	public PeekingIterator(Iterator<Integer> iterator) {
        q = new LinkedList<>();
        it = iterator;   
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (q.isEmpty()) {
            q.offer(it.next());
        }
        return q.peek();
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (q.isEmpty()) {
            return it.next();
        }
        return q.poll();
	}
	
	@Override
	public boolean hasNext() {
	    return !q.isEmpty() || it.hasNext();
	}
}