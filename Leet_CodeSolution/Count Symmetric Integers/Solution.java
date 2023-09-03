class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count=0;
        for(int j=low;j<=high;j++)
        {
            String str=Integer.toString(j);
            if(str.length()%2==0)
            {
                int sum1=0,sum2=0;
                for(int i=0;i<str.length()/2;i++)
                { 
                    sum1+=str.charAt(i)-'0';
                }
                for(int i=str.length()/2;i<str.length();i++)
                { 
                    sum2+=str.charAt(i)-'0';
                }
                if(sum1==sum2)
                {
                    count++;
                }
            }
        }
        
        return count;
    }
}
