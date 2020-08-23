class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            l.add(index[i],nums[i]);
        }
        
        int arr[]=new int[nums.length];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=l.get(i);
        }
        
        return arr;
        
    }
}
