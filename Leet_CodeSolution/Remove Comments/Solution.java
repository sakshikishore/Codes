class Solution {
    public List<String> removeComments(String[] source) {
        List<String>  result=new ArrayList<String>();
        int flag=0;
        String res="";
        for(int j=0;j<source.length;j++)
        {
           String str=source[j];
           for(int i=0;i<str.length();i++)
           {
              if(i!=str.length()-1)
              {
                  if(str.charAt(i)=='/' && str.charAt(i+1)=='/' && flag==0)
                  {
                    break;
                  }
                  else if(str.charAt(i)=='/' && str.charAt(i+1)=='*' && flag==0)
                  {
                    flag=1;
                    i++;
                  }
                  else if(str.charAt(i)=='*' && str.charAt(i+1)=='/' && flag==1)
                  {
                    flag=0;
                    i++;
                  }
                   else if(flag==0)
                  {
                    res+=str.charAt(i);
                  }
              }
              else if(flag==0)
              {
                    res+=str.charAt(i);
              }
           }
           if(flag==0)
              {
                if(res.length()>0)
                {
                     result.add(res);
                     res="";
                }
              }
        }

        return result;
    }
}
