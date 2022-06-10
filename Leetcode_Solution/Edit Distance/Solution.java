class Solution {
    public int minDistance(String text1, String text2) {
        int arr[][]=new int[text2.length()+1][text1.length()+1];
        for(int i=0;i<=text1.length();i++)
        {
            arr[0][i]=i;
        }
        for(int i=0;i<=text2.length();i++)
        {
            arr[i][0]=i;
        }
        for(int i=1;i<=text2.length();i++)
        {
            for(int j=1;j<=text1.length();j++)
            {
                if(text2.charAt(i-1)==text1.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1];
                }
                else
                {
                    int min=Math.min(arr[i][j-1],arr[i-1][j-1]);
                    min=Math.min(arr[i-1][j],min);
                    arr[i][j]=min+1;
                }
            }
        }
        
        int ans=arr[text2.length()][text1.length()];
        
        return ans;
        
    }
}
