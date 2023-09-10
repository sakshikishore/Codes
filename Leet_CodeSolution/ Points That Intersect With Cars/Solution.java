class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        HashSet<Integer> h=new HashSet<Integer>();
        for(int i=0;i<nums.size();i++)
        {
            for(int j=nums.get(i).get(0);j<=nums.get(i).get(1);j++)
            {
                h.add(j);
            }
        }
        
        return h.size();
    }
}
