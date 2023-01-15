class Solution {
    public long countGood(int[] nums, int k) {
        long result=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int i=0,totalPairs=0;
        for(int j=0;j<nums.length;j++)
        { 
            if(j!=0)
            {
                       int y=h.get(nums[j-1]);
                        if(y==1)
                        {
                            h.remove(nums[j-1]);
                        }
                        else
                        {
                            totalPairs=totalPairs-((y*(y-1))/2);
                            h.put(nums[j-1],y-1);
                            totalPairs+=(((y-1)*(y-2))/2);
                            
                        }
            }
            if(totalPairs>=k)
            {
                 result+=nums.length-i+1;
                        
                continue;
                
            }
                
            
            while(i<nums.length)
            {
            
                if(!h.containsKey(nums[i]))
                {
                    h.put(nums[i],1);
                    i++;
                }
                else
                {
                    int x=h.get(nums[i]);
                    totalPairs=totalPairs-((x*(x-1))/2);
                    h.put(nums[i],x+1);
                    totalPairs+=((x*(x+1))/2);
                    if(totalPairs>=k)
                    {
                        result+=nums.length-i;
                        i++;
                        break;
                    
                    }
                    i++;
                }
            }
        }
        
        return result;
    }
}
