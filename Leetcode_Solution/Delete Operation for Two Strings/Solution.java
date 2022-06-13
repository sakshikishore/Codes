class Solution {
    public int minDistance(String word1, String word2) {
        int arr[][]=new int[word1.length()+1][word2.length()+1];
        for(int i=1;i<=word1.length();i++)
        {
            for(int j=1;j<=word2.length();j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                {
                    arr[i][j]=arr[i-1][j-1]+1;
                }
                else
                {
                    arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
                }
            }
        }
        
        int p=arr[word1.length()][word2.length()];
        
        return word1.length()-p+word2.length()-p;
    }
}
