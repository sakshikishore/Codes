class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums.length==1)
        {
            return false;
        }
         HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
         h.put(0,-1);
         long sum=0;
        boolean result=false;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            long r=sum%k;
            int p=(int)(r);
            if(!h.containsKey(p))
            {
                h.put(p,i);
            }
            else
            {
                int x=h.get(p);
                if(i-x>1)
                {
                    result=true;
                    break;
                }
            }
        }
        
        return result;
    }
}
