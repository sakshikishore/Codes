class Solution {
    public int[] sortByReflection(int[] nums) {
        Arrays.sort(nums);
        int result[]=new int[nums.length];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
        HashMap<Integer,ArrayList<Integer>> h=new HashMap<Integer,ArrayList<Integer>>();
        for(int i=0;i<nums.length;i++)
        {
            StringBuffer sb=new StringBuffer("");
            int x=nums[i];
            while(x>0)
            {
                int r=(x & 1);
                if(r==1)
                {
                sb.append("1");
                }
                else
                {
                    sb.append("0");
                }
                x>>=1;
            }

            String str=new String(sb);
            int p=Integer.parseInt(str,2);
            if(!h.containsKey(p))
            {
                pq.add(p);
                ArrayList<Integer> l=new ArrayList<Integer>();
                l.add(nums[i]);
                h.put(p,l);
            }
            else
            {
                ArrayList<Integer> l=h.get(p);
                l.add(nums[i]);
                h.put(p,l);
            }
        }
        int j=0;
      while(pq.size()>0)
      {
         int x=pq.poll();
         ArrayList<Integer> l=h.get(x);
         for(int i=0;i<l.size();i++)
         {
            result[j]=l.get(i);
            j++;
         }
      }

      return result;
    }
}
