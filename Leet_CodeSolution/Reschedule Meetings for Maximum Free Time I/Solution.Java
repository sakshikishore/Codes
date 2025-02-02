class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int max=0;
        int start=-1,end=-1;
        int pref[]=new int[startTime.length];
        pref[0]=endTime[0]-startTime[0];
        for(int i=0;i<k;i++)
            {
              if(i==0)
              {
                  start=0;
                  end=(endTime[0]-startTime[0]);
              }
              else
              {
                  pref[i]=pref[i-1]+(endTime[i]-startTime[i]);
                  if(startTime[i]-end>max)
                  {
                      max=startTime[i]-end;
                  }
                  end=end+(endTime[i]-startTime[i]);
              }
            }
        int j=0;
          for(int i=k;i<startTime.length;i++)
              {
                  start=endTime[j];
                 if(startTime[i]-end>max)
                  {
                      max=startTime[i]-end;
                  }
                  end=start+pref[i-1]-pref[j];
                  end=end+(endTime[i]-startTime[i]);
                  pref[i]=pref[i-1]+(endTime[i]-startTime[i]);
                  j++;
              }
                  if(eventTime-end>max)
                  {
                      max= eventTime-end;
                  }

        return max;
    }
}
