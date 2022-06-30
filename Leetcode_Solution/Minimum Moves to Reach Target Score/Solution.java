class Solution {
    public int minMoves(int target, int maxDoubles) {
        if(maxDoubles==0)
        {
            return target-1;
        }
        ArrayList<Integer> l=new ArrayList<Integer>();
        int p=target;
        for(int i=0;i<maxDoubles;i++)
        {
            p=p/2;
            if(p!=0)
            {
                l.add(p);
            }
            else
            {
                break;
            }
        }
        int count=0;
        int x=1;
        int j=l.size()-1;
        while(x!=target)
        {
           if(j>=0)
           {
              if(l.get(j)!=x)
              {
                  count+=l.get(j)-x;
                  x=l.get(j);
              }
              else
              {
                  x=x*2;
                  count+=1;
                  j--;
              }
           }
           else
           {
               count+=target-x;
               x=target;
           }
        }
        
        return count;
    }
}
