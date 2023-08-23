class Solution {
    public String optimalDivision(int[] nums) {
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<nums.length;i++)
        {
            if(i==0 && i+1<nums.length && i+2<nums.length)
            {
                sb.append(Integer.toString(nums[i])+"/(");
            }
            else
            {
              if(i+1<nums.length)
              {
                  sb.append(Integer.toString(nums[i])+"/");
              }
              else
              {
                  sb.append(Integer.toString(nums[i]));
                  if(nums.length>2)
                  {
                      sb.append(")");
                  }
              }
            }
        }

        return sb.toString();
    }
}
