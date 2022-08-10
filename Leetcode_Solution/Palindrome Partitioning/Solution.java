class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> list=new ArrayList();
        for(int i=0;i<s.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        for(int i=0;i<s.length();i++)
        {
            String str=s.substring(0,i+1);
            if(i==0)
            {
                list.get(i).add(str);
            }
            else
            {
                 StringBuffer sb=new StringBuffer(str);
                 String p=new String(sb.reverse());
                 if(p.equals(str))
                 {
                     list.get(i).add(str);
                 }
                for(int k=i;k>=1;k--)
                {
                    String s1=str.substring(k);
                    sb=new StringBuffer(s1);
                      p=new String(sb.reverse());
                     if(p.equals(s1))
                     {
                       for(int j=0;j<list.get(k-1).size();j++)
                       {
                           p=list.get(k-1).get(j);
                           p=p+" "+s1;
                           list.get(i).add(p);
                       }
                     }
                    
                }
            }
        }
        
        List<List<String>> result=new ArrayList();
        int n=s.length()-1;
       // System.out.println(n);
        for(int i=0;i<list.get(n).size();i++)
        {
          String st[]=list.get(n).get(i).split(" ");
            ArrayList<String> al=new ArrayList<String>();
            for(int j=0;j<st.length;j++)
            {
                al.add(st[j]);
            }
            result.add(al);
        }
        
        return result;
        
    }
             
            
}
