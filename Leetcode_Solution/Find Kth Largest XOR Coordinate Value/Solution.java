class Solution {
    public int kthLargestValue(int[][] matrix, int k) {
        int result=0;
        int arr[][]=new int[matrix.length][matrix[0].length];
        PriorityQueue<Integer> pq=new PriorityQueue<Integer>(Collections.reverseOrder());
        int a[][]=new int[matrix.length][matrix[0].length];
        for(int i=0;i<a[0].length;i++)
        {
            for(int j=0;j<a.length;j++)
            {
               if(j==0)
               {
                   a[j][i]=matrix[j][i];
               }
               else
               {
                   a[j][i]=a[j-1][i]^matrix[j][i];
               }
            }
        }
        for(int i=0;i<arr.length;i++)
        {
            for(int j=0;j<arr[i].length;j++)
            {
                if(i==0 && j==0)
                {
                    arr[i][j]=matrix[i][j];
                }
                else if(i==0)
                {
                    arr[i][j]=matrix[i][j]^arr[i][j-1];
                }
                else if(j==0)
                {
                    arr[i][j]=arr[i-1][0]^matrix[i][0];
                }
                else
                {
                    arr[i][j]=(matrix[i][j]^arr[i][j-1]);
                    arr[i][j]=arr[i][j]^a[i-1][j];
                }
              pq.add(arr[i][j]);
            }
        }
        int count=0;
        while(count!=k)
        {
            result=pq.poll();
            count++;
            if(count==k)
            {
                break;
            }
        }
        
        return result;
    }
}
