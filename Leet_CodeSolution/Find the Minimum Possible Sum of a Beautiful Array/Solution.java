class Solution {
    public long minimumPossibleSum(int n, int target) {
        HashSet<Integer> hset=new HashSet<Integer>();
        long ans=1;
        int i=2;
        hset.add(1);
        while(hset.size()<n)
        {
            int x=target-i;
            if(hset.contains(x))
            {
                i++;
            }
            else
            {
                hset.add(i);
                ans=ans+i;
                i++;
            }
        }
        
        return ans;
    }
}
