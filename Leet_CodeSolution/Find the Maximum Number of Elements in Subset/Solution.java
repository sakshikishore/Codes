class Solution {
    public int maximumLength(int[] nums) {
        TreeMap<Integer,Integer> t=new TreeMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!t.containsKey(nums[i]))
            {
                t.put(nums[i],1);
            }
            else
            {
                t.put(nums[i],t.get(nums[i])+1);
            }
        }
        int max=0;
        for(Map.Entry<Integer,Integer> entry:t.entrySet())
        {
            int k=1;
            int x=entry.getKey();
            if(x==1)
            {
               int val=t.get(x);
                if(val%2==0)
                {
                    max=val-1;
                }
                else
                {
                    max=val;
                }
                continue;
            }
            int result=0;
            while(t.containsKey(x))
            {
                if(t.containsKey(x))
                {
                    if(t.get(x)==1)
                    {
                        result=result+1;
                        break;
                    }
                    else
                    {
                        result+=2;
                    }
                }
                k=k*2;
                x=(int)Math.pow(x,2);
            }
            if(result%2==0)
            {
                result=result-1;
            }
            if(result>max)
            {
               max=result;
            }
                
        }
        
        return max;
    }
}
