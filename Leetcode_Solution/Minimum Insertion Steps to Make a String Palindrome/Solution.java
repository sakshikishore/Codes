class Solution {
    public int minInsertions(String s) {
        int arr[][]=new int[s.length()][s.length()];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr.length-i;j++)
            {
                if(i==0)
                {
                    arr[j][j]=1;
                }
                else if(i==1)
                {
                    if(s.charAt(j)==s.charAt(j+i))
                    {
                        arr[j][j+i]=2;
                    }
                    else
                    {
                         arr[j][j+i]=Math.max(arr[j][j+i-1],arr[j+1][j+i]);
                    }
                }
                else
                {

                    if(s.charAt(j)==s.charAt(j+i))
                    {
                       arr[j][j+i]=2+arr[j+1][j+i-1];
                    }
                    else
                    {
                        arr[j][j+i]=Math.max(arr[j][j+i-1],arr[j+1][j+i]);
                    }
                }
            }
        }
        
        return s.length()-arr[0][arr.length-1];
    }
}
