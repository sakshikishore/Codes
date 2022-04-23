class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int decimal=-1;
        ArrayList<Integer> l=new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++)
        {
          l.add(Integer.parseInt(nums[i],2));
        }
        
         for(int i=0;i<nums.length;i++)
         {
             if(!l.contains(i))
             {
                 decimal=i;
                 break;
             }
         }
        
        if(decimal==-1)
        {
            decimal=nums.length;
        }
        
        String result=Integer.toBinaryString(decimal);
        while(result.length()<nums.length)
        {
            result="0"+result;
        }
        
        return result;
        
    }
}
