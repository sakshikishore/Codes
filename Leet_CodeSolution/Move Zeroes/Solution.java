class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> q=new LinkedList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
            {
                q.add(i);
            }
            else
            {
                if(q.size()!=0)
                {
                    int x=q.poll();
                    nums[x]=nums[i];
                    nums[i]=0;
                    q.add(i);
                }
            }
        }
    }
}
