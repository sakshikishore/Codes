class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
       int result[]=new int[queries.length];
       for(int i=0;i<queries.length;i++)
       {
           for(int j=0;j<points.length;j++)
           {
               int p=(queries[i][0]-points[j][0])*(queries[i][0]-points[j][0]);
               int q=(queries[i][1]-points[j][1])*(queries[i][1]-points[j][1]);
               p=p+q;
               if(p<=(queries[i][2]*queries[i][2]))
               {
                   result[i]++;
               }
           }
       }
        
        return result;
        
        
    }
}
