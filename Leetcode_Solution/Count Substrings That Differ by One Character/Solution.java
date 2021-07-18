class Solution {
    public int countSubstrings(String s, String t) {
        ArrayList<String> l=new ArrayList<String>();
        ArrayList<String> m=new ArrayList<String>();
        int result=0;
        for(int i=0;i<s.length();i++)
        {
            for(int j=i+1;j<=s.length();j++)
            {
              l.add(s.substring(i,j));
            }
        }
        
        for(int i=0;i<t.length();i++)
        {
            for(int j=i+1;j<=t.length();j++)
            {
              m.add(t.substring(i,j));
            }
        }
        for(int i=0;i<l.size();i++)
        {
            for(int j=0;j<m.size();j++)
            {
                if(m.get(j).length()==l.get(i).length())
                {
                    int count=0;
                   for(int p=0;p<m.get(j).length();p++)
                   {
                       if(m.get(j).charAt(p)!=l.get(i).charAt(p))
                       {
                           count++;
                           if(count>2)
                           {
                               break;
                           }
                       }
                   }
                    
                    if(count==1)
                    {
                        result++;
                    }
                }
              
            }
        }
        
        return result;
        
    }
}
