class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            l.add(nums[i]);
        }
        Collections.sort(l,Collections.reverseOrder());
        return l.get(k-1);
        
    }
}
