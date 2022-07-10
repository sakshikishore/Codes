class SmallestInfiniteSet {
    ArrayList<Integer> l;
    
    public SmallestInfiniteSet() {
        l=new ArrayList<Integer>();
    }
    
    public int popSmallest() {
        Collections.sort(l);
        int ans=0;
        int i=1;
       for(int j=0;j<l.size();j++)
       {
           if(l.get(j)!=i)
           {
               l.add(i);
               ans=i;
               break;
           }
           i++;
       }
        if(ans==0)
        {
            ans=i;
            l.add(i);
        }
        return ans;
        
    }
    
    public void addBack(int num) {
        if(l.contains(num))
        {
            l.remove(new Integer(num));
        }
    }
}
