class Solution {
    public int distinctAverages(int[] nums) {
        int i=0,j=nums.length-1;
        Arrays.sort(nums);
        HashSet<Double> h=new HashSet<Double>();
        while(i<j)
        {
            int x=nums[i]+nums[j];
            double avg=x/2.0;
            h.add(avg);
            i++;
            j--;
        }
        
        return h.size();
    }
}
