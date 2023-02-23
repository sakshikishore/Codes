class Solution {
    public int minImpossibleOR(int[] nums) {
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            h.add(nums[i]);
        }
        for(int i=0;i<32;i++)
        {
            int x=(int)Math.pow(2,i);
            if(!h.contains(x))
            {
              return x; 
            }   
        }

        return 1;
    }
}
