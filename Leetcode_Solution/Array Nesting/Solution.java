class Solution {
    public int arrayNesting(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int count=0;
            int x=nums[i];
            if(!hm.containsKey(x))
            {            
            HashSet<Integer> h=new HashSet<Integer>();
            while(!h.contains(x))
            {
                count++;
                h.add(x);
                x=nums[x];
            }
                Iterator<Integer> itr=h.iterator();
                while(itr.hasNext())
                {
                    hm.put(itr.next(),count);
                }
                
            if(count>max)
            {
                max=count;
            }
            }
        }

        return max;
    }
}
