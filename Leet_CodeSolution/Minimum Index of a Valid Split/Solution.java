class Solution {
    public int minimumIndex(List<Integer> nums) {
        if(nums.size()==1)
        {
            return -1;
        }
        int val=-1;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.size();i++)
        {
            if(!h.containsKey(nums.get(i)))
            {
                h.put(nums.get(i),1);
            }
            else
            {
                h.put(nums.get(i),h.get(nums.get(i))+1);
                if(h.get(nums.get(i))>nums.size()/2)
                {
                    val=nums.get(i);
                    break;
                }
            }
        }
        
        int prefix[]=new int[nums.size()];
        int suffix[]=new int[nums.size()];
        int p=0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums.get(i)==val)
            {
                p++;
            }
            prefix[i]=p;
        }
        int s=0;
        for(int i=nums.size()-1;i>=0;i--)
        {
            if(nums.get(i)==val)
            {
                s++;
            }
            suffix[i]=s;
        }
        for(int i=0;i<nums.size()-1;i++)
        {
            int n=i+1;
            int m=nums.size()-i-1;
            if(prefix[i]*2>n && suffix[i+1]*2>m)
            {
                return i;
            }
        }
        
        return -1;
    }
}
