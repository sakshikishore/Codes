class Solution {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> result=new ArrayList<String>();
        List<List<String>> list=new ArrayList();
        for(int i=0;i<s.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }

        for(int i=0;i<s.length();i++)
        {
            if(i<3)
            {
                String str=s.substring(0,i+1);
                list.get(i).add(str);
                for(int j=i;j>=1;j--)
                {
                    str=s.substring(j,i+1);
                    for(int k=0;k<list.get(j-1).size();k++)
                    {
                        String st=list.get(j-1).get(k);
                        st=st+" "+str;
                        list.get(i).add(st);
                    }
                }
            }
            else
            {
                for(int j=i;j>=(i-2);j--)
                {
                   String str=s.substring(j,i+1);
                    for(int k=0;k<list.get(j-1).size();k++)
                    {
                        String st=list.get(j-1).get(k);
                        String s1[]=st.split(" ");
                        if(s1.length<4)
                        {
                            st=st+" "+str;
                            list.get(i).add(st);
                        }
                    }
                }
            }
        }
        int n=s.length()-1;
        for(int i=0;i<list.get(n).size();i++)
        {
            String str[]=list.get(n).get(i).split(" ");
            int flag=0;
            if(str.length==4)
            {
                for(int j=0;j<str.length;j++)
                {
                    if(str[j].length()>1 && str[j].charAt(0)=='0')
                    {
                        flag=1;
                        break;
                    }
                    else
                    {
                        int x=Integer.parseInt(str[j]);
                        if(x>255)
                        {
                            flag=1;
                            break;
                        }
                    }
                }
            if(flag==0)
            {
               String s1="";
               for(int j=0;j<str.length;j++)
               {
                   if(j==0)
                   {
                       s1=s1+str[j];
                   }
                   else
                   {
                       s1=s1+"."+str[j];
                   }
               }
                
                result.add(s1);
            }
        }
            
        }
        
        return result;
    }
}
