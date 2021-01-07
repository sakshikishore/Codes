// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> itr;
    int p=0,result=0;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        
	    itr=iterator;
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(p==0)
        {
         result=itr.next();
         p=1;
        }
        return result;
        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        if(p==0)
        {
            result=itr.next();
        }
        else
        {
            p=0;
        }
        return result;
	    
	}
	
	@Override
	public boolean hasNext() {
        boolean res;
        if(p==1)
        {
            res=true;
        }
        else
        {
            res= itr.hasNext();
        }
        return res;
	    
	}
}
