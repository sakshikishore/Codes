class Solution {
    public String longestPalindrome(String s) {
        int arr[][]=new int[s.length()][s.length()];
        String result=s.substring(0,1);
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=0;j<s.length()-i;j++)
            {

                if(i==0)
                {
                    arr[j][j]=1;
                }
                else if(i==1)
                {
                    if(s.charAt(j)==s.charAt(j+i))
                    {
                        result=s.substring(j,j+i+1);
                        arr[j][j+i]=1;
                    }
                   
                }
                else
                {
                    if(s.charAt(j)==s.charAt(j+i))
                    {
                        if(arr[j+1][j+i-1]==1)
                        {
                            result=s.substring(j,j+i+1);
                            arr[j][j+i]=1;
                        }
                    }
                }
            }
        }
        
        return result;
    }
}
