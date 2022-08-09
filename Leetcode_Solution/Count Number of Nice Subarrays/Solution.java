class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       int index=0;
       int count=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]%2==0)
            {
                count++;
            }
            else
            {
                index++;
                h.put(index,count+1);
                count=0;
            }
        }
        if(count!=0 && index>0)
        {
            h.put(index+1,count+1);
        }
        count=0;
        if(index<k || index==1)
        {
            return 0;
        }
        else
        {
            for(int i=1;i<=index-k+1;i++)
            {
                int a=h.get(i);
                int b=1;
                if(h.containsKey(i+k))
                {
                    b=h.get(i+k);
                }
                
                count=count+(a*b);
            }
        }
        
        return count;
    }
}
