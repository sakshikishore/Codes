class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++)
        {
            int x=nums[i];
            int val=0;
            int j=0;
            while(x>0)
            {
                int r=x%10;
                val=(mapping[r]*(int)Math.pow(10,j))+val;
                j++;
                x=x/10;
            }
            if(nums[i]==0)
            {
                val=mapping[0];
            }
            if(!h.containsKey(val))
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(nums[i]);
                h.put(val,al);
                pq.add(val);
            }
            else
            {
                ArrayList<Integer> al=h.get(val);
                al.add(nums[i]);
                h.put(val,al);
            }

        }
        int result[]=new int[nums.length];
        int k=0;
        while(pq.size()>0)
        {
            int val=pq.poll();
            ArrayList<Integer> l=h.get(val);
            for(int i=0;i<l.size();i++)
            {
                result[k]=l.get(i);
                k++;
            }
        }

        return result;
    }
}
