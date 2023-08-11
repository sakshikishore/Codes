class StockPrice {
   int currentPrice=0,latestTimestamp=0;
   ArrayList<Integer> l;
   HashMap<Integer,Integer> h;
    public StockPrice() {
        l=new ArrayList<Integer>();
        h=new HashMap<Integer,Integer>();
    }
    
    public void update(int timestamp, int price) {
         if(timestamp>latestTimestamp)
         {
             latestTimestamp=timestamp;
         }
         if(!h.containsKey(timestamp))
         {
             h.put(timestamp,price);
             int low=0, high=l.size()-1,index=0;
              while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)>=price)
                 {
                     index=mid;
                     high=mid-1;
                 }
                 else
                 {
                       index=mid+1;
                       low=mid+1;
                 }
             }
             l.add(index,price);
         }
         else
         {
             int x=h.get(timestamp);
             h.put(timestamp,price);
             int low=0,high=l.size()-1;
             while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)==x)
                 {
                     l.remove(mid);
                     break;
                 }
                else if(l.get(mid)>x)
                 {
                     high=mid-1;
                 }
                 else
                 {
                       low=mid+1;
                 }
             }
             low=0;
             high=l.size()-1;
             int index=0;
              while(low<=high)
             {
                 int mid=(low+high)/2;
                 if(l.get(mid)>=price)
                 {
                     index=mid;
                     high=mid-1;
                 }
                 else
                 {
                       index=mid+1;
                       low=mid+1;
                 }
             }
             l.add(index,price);

         }
    }
    
    public int current() {
        return h.get(latestTimestamp);
    }
    
    public int maximum() {
        return l.get(l.size()-1);
    }
    
    public int minimum() {
        return l.get(0);
    }
}
