// Problem 284 Peeking Iterator

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    Integer peek; // visit and store next element
    Iterator<Integer> itr;
	public PeekingIterator(Iterator<Integer> iterator) {
	    this.itr = iterator;
        peek = itr.hasNext() ? itr.next() : null;
	    
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (peek == null) 
            throw new java.util.NoSuchElementException();
        Integer res = peek;
        peek = itr.hasNext() ? itr.next() : null;
        return res;
	}

	@Override
	public boolean hasNext() {
	    return peek != null;
	}
}