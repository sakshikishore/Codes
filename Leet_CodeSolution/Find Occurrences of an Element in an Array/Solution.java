class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int result[]=new int[queries.length];
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==x)
            {
                l.add(i);
            }
        }
        
        for(int i=0;i<queries.length;i++)
        {
            if(l.size()<queries[i])
            {
                result[i]=-1;
            }
            else
            {
                result[i]=l.get(queries[i]-1);
            }
        }
        
        return result;
    }
}
