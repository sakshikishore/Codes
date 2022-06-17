class Solution {
    public int[][] imageSmoother(int[][] img) {
        int arr[][]=new int[img.length][img[0].length];
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)   
            {
                int count=1;
                int sum=0;
                sum=img[i][j];
                if(j+1<img[i].length)
                {
                    sum+=img[i][j+1];
                    count++;
                }
                if(j-1>=0)
                {
                    sum+=img[i][j-1];
                    count++;
                }
                if(i+1<arr.length)
                {
                    sum+=img[i+1][j];
                    count++;
                    if(j+1<img[i].length)
                    {
                        sum+=img[i+1][j+1];
                        count++;
                    }
                     if(j-1>=0)
                     {
                        sum+=img[i+1][j-1];
                        count++;
                     }
                    
                }
                if(i-1>=0)
                {
                    sum+=img[i-1][j];
                    count++;
                    if(j+1<img[i].length)
                    {
                        sum+=img[i-1][j+1];
                        count++;
                    }
                     if(j-1>=0)
                     {
                        sum+=img[i-1][j-1];
                        count++;
                     }
                }
                
                arr[i][j]=sum/count;
                
                
            }
        }
        
        return arr;
    }
}
