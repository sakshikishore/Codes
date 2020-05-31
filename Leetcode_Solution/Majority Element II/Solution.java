
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        int p=nums.length/3;
   
        ArrayList<Integer> l=new ArrayList< Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(!h.containsKey(nums[i]))
            {
                h.put(nums[i],1);
                if(p<1)
                {
                    l.add(nums[i]);
                }
            }
            else
            {
                h.put(nums[i],h.get(nums[i])+1);
                if(!l.contains(nums[i]))
                {
                    if(h.get(nums[i])>p)
                    {
                        l.add(nums[i]);
                    }
                }
            }
        }
   
        return l;
        
    }
}
