class Solution {
    public int[] findOriginalArray(int[] changed) {
        if(changed.length%2!=0)
        {
            int result[]=new int[0];
            return result;
        }
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
       Arrays.sort(changed);
        for(int i=0;i<changed.length;i++)
        {
            if(!h.containsKey(changed[i]))
            {
                h.put(changed[i],1);
            }
            else
            {
                h.put(changed[i],h.get(changed[i])+1);
            }
        }
        int flag=0;
        int result[]=new int[changed.length/2];
        int j=0;
        for(int i=0;i<changed.length;i++)
        {
           if(h.containsKey(changed[i]))
           {
               int x=changed[i]*2;
               if(h.containsKey(x))
               {
                   if(x==0 && h.get(x)==1)
                   {
                       flag=1;
                       break;
                   }
                   result[j]=changed[i];
                   j++;
                   if(h.get(changed[i])==1)
                   {
                       h.remove(changed[i]);
                   }
                   else
                   {
                       h.put(changed[i],h.get(changed[i])-1);
                   }
                   
                   if(h.get(x)==1)
                   {
                       h.remove(x);
                   }
                   else
                   {
                       h.put(x,h.get(x)-1);
                   }
               }
               else
               {
                   flag=1;
                   break;
               }
           }
        }
        
        if(flag==1)
        {
            result=new int[0];
            return result;
        }
        
        return result;
        

    }
}
