class Solution {
    public int destroyTargets(int[] nums, int space) {
        Arrays.sort(nums);
        int max=0;
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int p=nums[i]%space;
           if(!h.containsKey(p))
           {
            h.put(p,1);
            if(1>max){
                max=1;
            }
           }
           else
           {
            h.put(p,h.get(p)+1);
            if(h.get(p)>max)
            {
                max=h.get(p);
            }
           }
        }
         for(int i=0;i<nums.length;i++)
        {
            if(h.get(nums[i]%space)==max)
            {
                return nums[i];
            }
        }
        return 0;
    }
}
