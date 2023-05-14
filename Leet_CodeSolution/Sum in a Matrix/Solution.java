class Solution {
    public int matrixSum(int[][] nums) {
        List<PriorityQueue<Integer>> list=new ArrayList();
        for(int i=0;i<nums.length;i++)
        {
            PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
            list.add(pq);
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums[0].length;j++)
            {
                list.get(i).add(nums[i][j]);
            }
        }
        int result=0;
        for(int i=0;i<nums[0].length;i++)
        {
            int max=0;
            for(int j=0;j<nums.length;j++)
            {
                int val=list.get(j).poll();
                if(val>max)
                {
                    max=val;
                }
            }
            result+=max;
        }

        return result;
    }
}
