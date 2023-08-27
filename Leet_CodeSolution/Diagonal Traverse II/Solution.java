class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        int len=0;
        for(int i=0;i<nums.size();i++)
        {
            for(int j=0;j<nums.get(i).size();j++)
            {
                len++;
                int x=i+j;
                if(!h.containsKey(x))
                {
                    ArrayList<Integer> list=new ArrayList<Integer>();
                    list.add(nums.get(i).get(j));
                    h.put(x,list);
                    pq.add(x);
                }
                else
                {
                    ArrayList<Integer> list=h.get(x);
                    list.add(nums.get(i).get(j));
                    h.put(x,list);
                }
            }
        }
        int result[]=new int[len];
        int i=0;
        while(pq.size()>0)
        {
            int val=pq.poll();
            ArrayList<Integer> list=h.get(val);
            for(int j=list.size()-1;j>=0;j--)
            {
                result[i]=list.get(j);
                i++;
            }
        }

        return result;
    }
}
