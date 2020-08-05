class Solution {

    HashMap<Integer,String> h=new HashMap<Integer,String>();
    public Solution(int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            if(h.containsKey(nums[i]))
            {
                h.put(nums[i],h.get(nums[i])+" "+Integer.toString(i));
            }
            else
            {
                h.put(nums[i],Integer.toString(i));
            }
        }
        
    }
    
    public int pick(int target) {
        
        String p[]=h.get(target).split(" ");
        Random rand = new Random();
        int q=0;
        if(p.length>1)
        {
             
         q=rand.nextInt(p.length);
            
            
        }
        
        return Integer.parseInt(p[q]);
        
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
