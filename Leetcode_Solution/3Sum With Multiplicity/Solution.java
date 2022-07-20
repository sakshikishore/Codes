class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long result=0;
        for(int i=0;i<arr.length;i++)
        {
            int count[]=new int[101];
            for(int j=i+1;j<arr.length;j++)
            {
                int k=target-arr[i]-arr[j];
                if(k>=0 && k<=100)
                {
                  result+=count[k];
                  result=result%(1000000007);
                }
                
                count[arr[j]]++;
            }
        }
        
        return (int)result;
    }
}
