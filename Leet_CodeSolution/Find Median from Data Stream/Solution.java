class MedianFinder {
   PriorityQueue<Integer> minHeap;
   PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap=new PriorityQueue<Integer>();
        maxHeap=new PriorityQueue<Integer>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        if((minHeap.size()+maxHeap.size())%2==0)
        {
            if(maxHeap.size()==0)
            {
                maxHeap.add(num);
            }
            else
            {
                if(num>minHeap.peek())
                {
                    int x=minHeap.poll();
                    minHeap.add(num);
                    maxHeap.add(x);
                }
                else
                {
                    maxHeap.add(num);
                }
            }
        }
        else
        {
           
               if(num<maxHeap.peek())
               {
                  int x=maxHeap.poll();
                  maxHeap.add(num);
                  minHeap.add(x);
               }
               else
               {
                minHeap.add(num);
               }
            
        }
    }
    
    public double findMedian() {
        if((minHeap.size()+maxHeap.size())%2==0)
        {
            return (minHeap.peek()+maxHeap.peek())/2.0;
        }
        return maxHeap.peek()*1.0;
    }
}
