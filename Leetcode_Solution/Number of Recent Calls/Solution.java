class RecentCounter {

    ArrayList<Integer> l;
    public RecentCounter() {
        
        l=new ArrayList<Integer>();
    }
    
    public int ping(int t) {
        int result=0;
        l.add(t);
        int p=t-3000;
        for(int i=0;i<l.size();i++)
        {
            if(l.get(i)>=p)
            {
                result=l.size()-i;
                break;
            }
        }
        
        return result;
        
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
