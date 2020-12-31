class KthLargest {

    ArrayList<Integer> l=new ArrayList<Integer>();
    int p=0;
    public KthLargest(int k, int[] nums) {
        for(int i=0;i<nums.length;i++)
        {
            l.add(nums[i]);
        }
        p=k;
    }
    
    public int add(int val) {
        l.add(val);
        Collections.sort(l);
        return l.get(l.size()-p);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
