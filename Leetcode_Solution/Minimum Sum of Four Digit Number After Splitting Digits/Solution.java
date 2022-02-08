class Solution {
    public int minimumSum(int num) {
     ArrayList<Integer> l=new ArrayList<Integer>();
        int sum=0;
     while(num>0)
     {
         int r=num%10;
         if(r!=0)
         {
            l.add(r); 
         }
         num=num/10;
     }
        
        if(l.size()==1)
        {
            sum=l.get(0);
        }
        else if(l.size()==2)
        {
            sum=l.get(0)+l.get(1);
        }
        else if(l.size()==3)
        {
            Collections.sort(l);
            sum=(l.get(0)*10+l.get(2))+l.get(1);
        }
        else if(l.size()==4)
        {
            Collections.sort(l);
            sum=(l.get(0)*10+l.get(2))+(l.get(1)*10+l.get(3));
        }
        
        return sum;
        
    }
}
