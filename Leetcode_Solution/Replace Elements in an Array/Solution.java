class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        LinkedHashMap<Integer,Integer> h=new LinkedHashMap<Integer,Integer>();
        int result[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            h.put(nums[i],i);
            result[i]=nums[i];
        }
        for(int i=0;i<operations.length;i++)
        {
            int index=h.get(operations[i][0]);
            h.remove(operations[i][0]);
            h.put(operations[i][1],index);
            result[index]=operations[i][1];
        }
        
        return result;
    }
}
