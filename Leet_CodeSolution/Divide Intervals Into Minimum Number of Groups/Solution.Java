class Solution {
    public int minGroups(int[][] intervals) {
          int arr[]=new int[1000002];
          int result=0;
          for(int i=0;i<intervals.length;i++)
          {
            arr[intervals[i][0]]++;
            arr[intervals[i][1]+1]--;
          }

          for(int i=1;i<arr.length;i++)
          {
            arr[i]=arr[i-1]+arr[i];
            if(arr[i]>result)
            {
                result=arr[i];
            }
          }

          return result;
    }
}
