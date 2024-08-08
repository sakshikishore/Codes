class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        ArrayList<Boolean> result=new  ArrayList<Boolean> ();
       int ch[][]=new int[s.length()][26];
       for(int i=0;i<s.length();i++)
       {
           if(i==0)
           {
             ch[i][s.charAt(i)-'a']++;
           }
           else
           {
             ch[i][s.charAt(i)-'a']++;
             for(int j=0;j<26;j++)
             {
                ch[i][j]+=ch[i-1][j];
             }
           }
       } 
       
       for(int i=0;i<queries.length;i++)
       {
          if(queries[i][1]-queries[i][0]==0)
          {
            result.add(true);
          }
          else
          {
            
            int count=0;
            int k=queries[i][2];
            if(queries[i][0]==0)
            {
                  for(int j=0;j<26;j++)
                  {
                      if(ch[queries[i][1]][j]%2!=0)
                      {
                        count++;
                      }
                  }
            }
            else
            {
                int p[]=new int[26];
                for(int j=0;j<26;j++)
                {
                    p[j]=ch[queries[i][1]][j]-ch[queries[i][0]-1][j];
                    if(p[j]%2!=0)
                    {
                        count++;
                    }
                }
            }
            
                if(count<2)
                {
                    result.add(true);
                }
                else
                {
                    if(k>=count/2)
                    {
                       result.add(true);
                    }
                    else{
                          result.add(false);
                    }
                }

            
          }
       }

       return result;
    }
}
