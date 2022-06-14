class Solution {
    public int largestCombination(int[] candidates) {
     String str[]=new String[candidates.length];
        int max=0;
        for(int i=0;i<candidates.length;i++)
        {
            str[i]=Integer.toBinaryString(candidates[i]);
            if(str[i].length()>max)
            {
                max=str[i].length();
            }
        }
        
        for(int i=0;i<str.length;i++)
        {
           int len=str[i].length();
           for(int j=0;j<max-len;j++)
           {
               str[i]="0"+str[i];
           }
        }
        int result=0;
        for(int i=0;i<max;i++)
        {
            int count=0;
            for(int j=0;j<str.length;j++)
            {
                if(str[j].charAt(i)=='1')
                {
                    count++;
                }
            }
            
            if(count>result)
            {
                result=count;
            }
        }
        return result;
    }
}
