class Solution {
    public int minOperations(List<Integer> nums, int k) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        int j=nums.size()-1;
        int count=0;
        while(j>=0)
        {
            count++;
            if(!l.contains(nums.get(j)) && nums.get(j)<=k)
            {
                l.add(nums.get(j));
            }
            if(l.size()==k)
            {
                break;
            }
            j--;
        }

        return count;

    }
}
