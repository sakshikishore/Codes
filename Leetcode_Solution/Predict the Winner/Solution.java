class Solution {
   
    public boolean PredictTheWinner(int[] nums) {
        if(nums.length%2==0)
        {
            return true;
        }
        else
        {
            int arr[][]=new int[nums.length][nums.length];
            int sum=0;
            for(int i=0;i<nums.length;i++)
            {
                sum=sum+nums[i];
                for(int j=0;j<nums.length-i;j++)
                {
                    if(i==0)
                    {
                        arr[j][j]=nums[j];
                    }
                    else if(i==1)
                    {
                        arr[j][j+i]=Math.max(arr[j][j],arr[j+i][j+i]);
                    }
                    else
                    {
                        int k=j+i;
                        int p=arr[j][j]+(int)Math.min(arr[j+1][k-1],arr[j+2][k]);
                        int q=arr[k][k]+(int)Math.min(arr[j][k-2],arr[j+1][k-1]);
                        arr[j][j+i]=Math.max(p,q);
                    }
                }
            }
           int player1Score=arr[0][arr.length-1];
           int player2Score=sum-player1Score;
           if(player1Score>=player2Score)
           {
               return true;
           }
            else
            {
                return false;
            }
            
        }
        
    }
}
