class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int maxArea=0;
        for(int i=0;i<matrix.length;i++)
        {
            ArrayList<Integer> l=new ArrayList<Integer>();
            for(int j=0;j<matrix[i].length;j++)
            {
               if(i>0)
               {
                   if(matrix[i][j]==1)
                   {
                       matrix[i][j]=matrix[i-1][j]+1;
                   }
               }
                if(matrix[i][j]>0)
                {
                   l.add(matrix[i][j]);
                }
            }
            Collections.sort(l);
            if(i==0)
            {
                maxArea=l.size();
            }
            else
            {
                int len=l.size();
                for(int j=0;j<len;j++)
                {
                    int val=l.get(j);
                    int area=val*(len-j);
                    if(area>maxArea)
                    {
                        maxArea=area;
                    }
                }
            }
        }
        
        return maxArea;
    }
}
