class Solution {
    public String[] largestString(int[] nums) {
      // a=1,b=2,c=4,d=8,e=16
      //a=2^0, b=2^1, c=2^2, d=2^3...
      String ans[]=new String[nums.length];
      for(int i=0;i<nums.length;i++)
      {
        StringBuffer sb=new StringBuffer("");
         while(nums[i]!=0)
         {
            int p=(int)(Math.log(nums[i])/Math.log(2));
            if(p==26)
            {
                p=25;
                sb.append("z");
            }
            else
            {
                sb.append((char)(97+p));
            }
            nums[i]=nums[i]-(int)(Math.pow(2,p));

         }
        
         ans[i]=new String(sb);
      }


     return ans;
       

    }
}
