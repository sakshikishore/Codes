class Solution {
    public int countTriplets(int[] arr) {
        int result=0;
        for(int i=0;i<arr.length;i++)
        {
            int p=0;
            for(int j=i+1;j<arr.length;j++)
            {
                
                p=p^arr[j-1];   
                int q=0;
                for(int k=j;k<arr.length;k++)
                {
                    q=q^arr[k];
                    if(p==q)
                    {
                        result++;
                    }
                }
            }
        }
        
        return result;
        
    }
}
