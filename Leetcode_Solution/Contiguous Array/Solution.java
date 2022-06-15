class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> h=new HashMap<Integer,Integer>();
        h.put(0,-1);
        int max=0,sum=0;
        for(int i=0;i<nums.length;i++)
        {
           if(nums[i]==0)
           {
              sum=sum-1;
           }
           else
           {
               sum=sum+1;
           }
              if(!h.containsKey(sum))
              {
                  h.put(sum,i);
              }
              else
              {
                  int value=h.get(sum);
                  if(i-value>max)
                  {
                      max=i-value;
                  }
              }
           
        }
        
        return max;
        
    }
}
