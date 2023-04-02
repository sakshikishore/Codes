class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int max=1;
        List<List<Integer>> result=new ArrayList();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
                if(h.get(nums[i])>max)
                {
                    max=h.get(nums[i]);
                }
            }
        }
        for(int i=0;i<max;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            result.add(l);
        }
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            int key=entry.getKey();
            int val=entry.getValue();
            for(int i=0;i<val;i++)
            {
                result.get(i).add(key);
            }
        }
        
        return result;
        
        
    }
}
