class Solution {
    public List<Integer> intersection(int[][] nums) {
        ArrayList<Integer> result=new ArrayList<Integer>();
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[i].length;j++)
            {
                if(!h.containsKey(nums[i][j]))
                {
                    h.put(nums[i][j],1);
                }
                else
                {
                    h.put(nums[i][j],h.get(nums[i][j])+1);
                }
            }

        }
        
        for(Map.Entry<Integer,Integer> entry:h.entrySet())
        {
            if(entry.getValue()==nums.length)
            {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
