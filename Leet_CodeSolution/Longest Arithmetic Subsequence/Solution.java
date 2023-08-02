class Solution {
    public int longestArithSeqLength(int[] nums) {
     int max=1;
      List<HashMap<Integer,Integer>> list=new ArrayList<HashMap<Integer,Integer>>();
      for(int i=0;i<nums.length;i++)
      {
          HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
          list.add(h);
      }
        for(int i=1;i<nums.length;i++)
        {
            for(int j=i-1;j>=0;j--)
            {
                 int p=nums[j]-nums[i];
                 if(list.get(j).containsKey(p))
                 {
                     int x=list.get(j).get(p);
                     if(list.get(i).containsKey(p))
                     {
                         int y=list.get(i).get(p);
                         if(x+1>y)
                         {
                             list.get(i).put(p,x+1);
                             if(x+1>max)
                             {
                                 max=x+1;
                             }
                         }
                     }
                     else
                     {
                         if(x+1>max)
                         {
                             max=x+1;
                         }
                         list.get(i).put(p,x+1);
                     }
                 }
                 else
                 {
                     if(!list.get(i).containsKey(p))
                     {
                         list.get(i).put(p,2);
                         if(2>max)
                         {
                             max=2;
                         }
                     }
                 }
                
            }
        }
        return max;
    }
}
