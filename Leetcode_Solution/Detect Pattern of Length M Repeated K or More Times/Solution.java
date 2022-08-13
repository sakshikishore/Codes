class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
      boolean result=false;
      for(int i=0;i<=arr.length-m;i++)
      {
              int j=i;
              String prev="";
              int count=0;
          while(j<arr.length)
          {
               String str="";
              int p=j;
              if(m+j>arr.length)
              {
                  break;
              }
              for(int x=j;x<(m+j);x++)
              {
                  str+=Integer.toString(arr[x]);
                  p++;
              }
              if(prev.length()==0)
              {
                  prev=str;
                  count=1;
                  if(count==k)
                  {
                      result=true;
                      break;
                  }
              }
              else
              {
                  if(str.equals(prev))
                  {
                      count++;
                      if(count==k)
                      {
                          result=true;
                          break;
                      }
                  }
                  else
                  {
                      count=1;
                  }
                  prev=str;
                  
              }
              
             
              j=p;       
          }
          if(result)
          {
              break;
          }
      }
        
        return result;
    }
}
