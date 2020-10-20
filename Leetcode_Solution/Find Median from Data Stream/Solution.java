class MedianFinder {

    /** initialize your data structure here. */
    ArrayList<Integer> l;
    public MedianFinder() {
        l=new ArrayList<Integer>();
    }
    
    public void addNum(int num) {
        l.add(num);
    }
    
    public double findMedian() {
        Collections.sort(l);
        double result=0.0;
        if(l.size()>0)
        {
            if(l.size()%2==0)
            {
                int p=l.size()/2;
                int q=p-1;
                result=(l.get(p)+l.get(q))/2.0;
            }
            else
            {
                int p=l.size()/2;    
                result=l.get(p);
            }
        }
        
        return result;
    
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
