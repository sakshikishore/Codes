class Solution {
    public int minimumBuckets(String street) {
        HashSet<Integer> h=new HashSet<Integer>();
        char c[]=street.toCharArray();
        int ans=-1;
        int totalHouse=0;
        int flag=0;
        for(int i=0;i<c.length;i++)
        {
            if(c[i]=='H')
            {
                totalHouse++;
            }
            if (i+1<c.length)
            {
                if(c[i]=='H' && c[i+1]=='H')
                {
                     if(i+2<street.length())
                     {
                         if(c[i+2]=='H')
                         {
                             flag=1;
                             break;
                         }
                     }
                    else
                    {
                        flag=1;
                        break;
                    }
                    if(flag==0)
                    {
                        if(i-1>=0)
                        {
                            if(c[i-1]=='H')
                            {
                                 flag=1;
                                 break;
                            }
                        }
                        else
                        {
                            flag=1;
                            break;
                        }
                    }
                }
            }
        }
        if(flag==1 || (totalHouse==c.length))
        {
            return ans;
        }
        if(totalHouse==0)
        {
            return 0;
        }
        int i=0;
        while(i<street.length())
        {
                if(!h.contains(i) && c[i]=='H')
                {
                    if(i+2<street.length())
                    {
                        if(c[i+1]=='.' && c[i+2]=='H')
                        {
                            h.add(i);
                            h.add(i+2);
                            i=i+2;
                        }
                    }
                }
            i++;
        }
        
       int remainingHouse=totalHouse-h.size();
        int x=h.size()/2;
        return  (remainingHouse+x);
        
    }
}
