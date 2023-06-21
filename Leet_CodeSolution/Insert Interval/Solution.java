class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
      Queue<Integer> q=new LinkedList<Integer>();
      int i=0;
      int s=newInterval[0];
      int e=newInterval[1];
      int r=-1;
      int flag=0;
      while(i<intervals.length)
      {
           if(intervals[i][1]<s)
           {
             q.add(i);
           }
           else if(e<intervals[i][0])
           {
              q.add(-1);
              q.add(i);
              r=i;
              break;
           }
           else
           {
                if(intervals[i][0]>=s && intervals[i][1]<=e)
                {
                  i++;
                  continue;
                }
                else if(intervals[i][0]<=s && intervals[i][1]>=e)
                {
                  q.add(i);
                  r=i;
                  flag=1;
                  break;
                }
                else
                {
                  if(intervals[i][0]<=s)
                  {
                    s=intervals[i][0];
                  }
                  if(intervals[i][1]>=e)
                  {
                    e=intervals[i][1];
                  }
                }
           }
           i++;
      }
      if(q.size()==0)
      {
        int result[][]=new int[1][2];
        result[0][0]=s;
        result[0][1]=e;
        return result;
      }
      if(flag==1)
      {
           return intervals;
      }
      if(r==-1)
      {
        int result[][]=new int[q.size()+1][2];
        i=0;
        while(q.size()>0)
        {
            int p=q.poll();
            result[i][0]=intervals[p][0];
            result[i][1]=intervals[p][1];
            i++;
        }
        result[i][0]=s;
        result[i][1]=e;

        return result;
      }
      
      int x=q.size()+(intervals.length-r-1);
      int result[][]=new int[x][2];
      i=0;
      while(q.size()>0)
      {
         int p=q.poll();
         if(p==-1)
         {
           result[i][0]=s;
           result[i][1]=e;
         }
         else
         {
           result[i][0]=intervals[p][0];
           result[i][1]=intervals[p][1];
         }
         i++;
      }
      for(int j=r+1;j<intervals.length;j++)
      {
         result[i][0]=intervals[j][0];
         result[i][1]=intervals[j][1];
           i++;
      }
      return result;
    }
}
