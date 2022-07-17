class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        Arrays.sort(nums);
        int max=-1;
        for(int i=0;i<nums.length;i++)
        {
            int n=nums[i],sum=0;
            while(n>0)
            {
                sum+=n%10;
                n=n/10;
            }
            if(!h.containsKey(sum))
            {
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(i);
                h.put(sum,l);
            }
            else
            {
                ArrayList<Integer> l=h.get(sum);
                if((nums[l.get(l.size()-1)]+nums[i])>max)
                {
                    max=nums[l.get(l.size()-1)]+nums[i];
                }
                l.add(i);
                h.put(sum,l);
            }
        }
        
        return max;
    }
}
