class Solution {
    public int[] frequencySort(int[] nums) {
        int count=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                count++;
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
            }
        }
      
        int p[]=new int[count];  
        int q[]=new int[count];
        int i=0;
        for(Map.Entry<Integer,Integer> m:h.entrySet())
        {
            p[i]=m.getKey();
            q[i]=m.getValue();
            i++;
        }
        for(int j=0;j<q.length;j++)
        {
            for(int k=j+1;k<q.length;k++)
            {
                if(q[j]>q[k])
                {
                    int temp=q[j];
                    q[j]=q[k];
                    q[k]=temp;
                    
                    temp=p[j];
                    p[j]=p[k];
                    p[k]=temp;
                                        
                }
                
                if(q[j]==q[k])
                {
                    if(p[j]<p[k])
                    {
                        int temp=p[j];
                        p[j]=p[k];
                        p[k]=temp;
                    }
                }
            }
        }
        
        int l=0;
        int result[]=new int[nums.length];
        for(int j=0;j<p.length;j++)
        {
            for(int k=0;k<q[j];k++)
            {
                result[l]=p[j];
                l++;
            }
        }
        
        return result;
        
    }
}
