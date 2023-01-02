class Solution {
    public int minimumPartition(String s, int k) {
        int count=0;
        int result=0;
        long num=0;
        for(int i=0;i<s.length();i++)
        {
            if(count==0)
            {
                num=s.charAt(i)-'0';
                if(num>k)
                {
                    return -1;
                }
                count=1;
            }
            else
            {
                num=num*10+s.charAt(i)-'0';
                if(num>k)
                {
                    result++;
                    count=0;
                    i--;
                }
            }
        }
        if(count==1)
        {
            result++;
        }
        
        return result;
    }
}
