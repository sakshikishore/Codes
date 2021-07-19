class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        char ch1[]=s1.toCharArray();
        char ch2[]=s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        boolean result=true;
        int flag=1;
        for(int i=0;i<ch1.length;i++)
        {
            if(ch1[i]<ch2[i])
            {
                result=false;
                break;
            }
        }
        if(!result)
        {
            result=true;
            for(int i=0;i<ch1.length;i++)
            {
                if(ch1[i]>ch2[i])
                {
                    flag=1;
                    result=false;
                    break;
                }
            }
        }
        
        return result;
       
        
        
    }
}
