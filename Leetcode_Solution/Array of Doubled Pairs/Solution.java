class Solution {
    public boolean canReorderDoubled(int[] A) {
        boolean result=false;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]<0)
            {
                A[i]=A[i]*-1;
            }
        }
        Arrays.sort(A);
        int count=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++)
        {
            if(!h.containsKey(A[i]))
            {
                h.put(A[i],1);
            }
            else
            {
                h.put(A[i],h.get(A[i])+1);
            }
            
        }
        int flag=1;
  
        if(h.containsKey(0))
        {
            if(h.get(0)%2!=0)
            {
                flag=0;
            }
            else
            {
                count=count+h.get(0);
            }
        }
        if(flag==1)
        {
        for(int i=0;i<A.length;i++)
        {
           if(A[i]!=0)
           {
               
            if(h.containsKey(A[i]))
            {
                if(h.containsKey(A[i]*2))
                {
                    count=count+2;
                    if(h.get(A[i]*2)==1)
                    {
                        h.remove(A[i]*2);
                    }
                    else
                    {
                        h.put(A[i]*2,h.get(A[i]*2)-1);
                    }
                    
                    System.out.println(h.get(A[i]));
                    
                    if(h.get(A[i])==1)
                    {
                        h.remove(A[i]);
                    }
                    else
                    {
                        h.put(A[i],h.get(A[i])-1);
                    }
                }
                else
                {
                    result=false;
                    break;
                }
            }
        }
    }
            
        }
        if(count==A.length)
        {
            result=true;
        }
        
        return result;
        
    }
}
