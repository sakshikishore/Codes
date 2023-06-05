class Solution {
    public long matrixSumQueries(int n, int[][] queries) {
       HashSet<Integer> row=new HashSet<Integer>();
       HashSet<Integer> col=new HashSet<Integer>();
       int c=n,r=n;
       long result=0;
      for(int i=queries.length-1;i>=0;i--)
      {
          int type=queries[i][0];
          if(type==0)
          {
              int r1=queries[i][1];
              if(!row.contains(r1))
              {
                  row.add(r1);
                  r--;
                  result+=(queries[i][2]*c);
              }
          }
          else
          {
              int c1=queries[i][1];
              if(!col.contains(c1))
              {
                  col.add(c1);
                  c--;
                  result+=(queries[i][2]*r);
              }
          }
          if(r==0 || c==0)
          {
              return result;
          }
      }
        
        return result;
    }
}
