class StockSpanner {
    ArrayList<Integer> l;
    int i=-1;

    public StockSpanner() {
     l=new ArrayList<Integer>();
        
    }
    
    public int next(int price) {
        int result=0;
        i++;
        if(i==0)
        {
            l.add(price);
            result=1;
        }
        else
        {          
            int j=l.size()-1;
            while(j>=0)
            {
                if(l.get(j)<=price)
                {
                    result++;
                }
                else
                {
                    break;
                }
                j--;
            }
            l.add(price);
            result++;
        }
     
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
