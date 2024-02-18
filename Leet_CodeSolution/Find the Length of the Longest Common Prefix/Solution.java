class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
       HashSet<Integer> hset1=new HashSet<Integer>();
       for(int i=0;i<arr1.length;i++)
       {
           
           while(arr1[i]>0)
           {
                hset1.add(arr1[i]);
               arr1[i]=arr1[i]/10;
               
           }
       }
        Arrays.sort(arr2);
        HashSet<Integer> hset2=new HashSet<Integer>();
        int pref=0;
       for(int j=arr2.length-1;j>=0;j--)
       {
           if(arr2[j]<pref)
           {
               break;
           }
           if(!hset2.contains(arr2[j]))
           {
               hset2.add(arr2[j]);
              while(arr2[j]>0)
              {
                  if(arr2[j]<pref)
                  {
                      break;
                  }
                  if(hset1.contains(arr2[j]))
                  {
                      pref=arr2[j];
                     
                      break;
                  }
                  else
                  {
                     
                      arr2[j]=arr2[j]/10;
                  }
              }
           }
       }
          if(pref==0)
          {
              return 0;
          }
          return Integer.toString(pref).length();
}
    }
    
  
