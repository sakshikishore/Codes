class Solution {
    public int minOperations(String s) {
        int count1=0,count2=0;
        for(int i=0;i<s.length();i=i+2)
        {
            if(s.charAt(i)!='1')
            {
                count1++;
            }
            if(i+1<s.length())
            {
                if(s.charAt(i+1)!='0')
                {
                    count1++;
                }
           }           
        }
        
        for(int i=0;i<s.length();i=i+2)
        {
            if(s.charAt(i)!='0')
            {
                count2++;
            }
            if(i+1<s.length())
            {
                if(s.charAt(i+1)!='1')
                {
                    count2++;
                }
           }           
        }
        
        return Math.min(count1,count2);
        
        
    }
}
