class Solution {
    public boolean digitCount(String num) {
        int nums[]=new int[10];
        boolean result=true;
        for(int i=0;i<num.length();i++)
        {
            nums[num.charAt(i)-'0']++;
        }
        for(int i=0;i<num.length();i++)
        {
            if(nums[i]!=Integer.parseInt(num.substring(i,i+1)))
            {
                result=false;
                break;
            }
        }
        
        return result;
        
    }
}
