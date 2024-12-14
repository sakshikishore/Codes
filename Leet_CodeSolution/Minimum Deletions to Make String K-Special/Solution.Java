class Solution {
    int result=Integer.MAX_VALUE;
    public void Solve(int arr[],int i, int j, int score,int k)
    {
        
        if(i>=j)
        {
            result=Math.min(result,score);
            return;
        }
        if(arr[j]-arr[i]<=k)
        {
            
             result=Math.min(result,score);
            return;
        }

        Solve(arr,i+1,j,score+arr[i],k);
        Solve(arr,i,j-1,score+arr[j]-arr[i]-k,k);

    }
    public int minimumDeletions(String word, int k) {
        int ch[]=new int[26];
      for(int i=0;i<word.length();i++)
      {
         ch[word.charAt(i)-'a']++;
      }
      int count=0;
      for(int i=0;i<26;i++)
      {
        if(ch[i]!=0)
        {
            count++;
        }
      }
      if(count==1)
      {
        return 0;
      }
      Arrays.sort(ch);
      int arr[]=new int[count];
      int t=0;
      while(ch[t]==0)
      {
        t++;
      }
      int j=0;
      for(int i=t;i<26;i++)
      {
        arr[j]=ch[i];
        j++;
      }

      Solve(arr,0,count-1,0,k);

      return result;
 
    }
}
