class Solution {
    public int maxUniqueSplit(String s) {
        List<List<String>> list=new ArrayList();
        for(int i=0;i<s.length();i++)
        {
            ArrayList<String> l=new ArrayList<String>();
            list.add(l);
        }
        for(int i=0;i<s.length();i++)
        {
            String str=s.substring(0,i+1);
            list.get(i).add(str);
            for(int j=i;j>=1;j--)
            {
                String st=str.substring(j);
                for(int k=0;k<list.get(j-1).size();k++)
                {
                    String s1=list.get(j-1).get(k);
                    if(!s1.contains(st))
                    {
                        s1=s1+" "+st;
                        list.get(i).add(s1);
                    }
                    else
                    {
                        int flag=0;
                        String a[]=s1.split(" ");
                        for(int y=0;y<a.length;y++)
                        {
                            if(a[y].equals(st))
                            {
                                flag=1;
                                break;
                            }
                        }
                        if(flag==0)
                        {
                             s1=s1+" "+st;
                             list.get(i).add(s1);
                        }
                    }
                }
            }
        }
        int n=s.length()-1;
        int max=0;
        for(int i=0;i<list.get(n).size();i++)
        {
            String str[]=list.get(n).get(i).split(" ");
            if(str.length>max)
            {
                max=str.length;
            }
        }
        
        return max;
    }
}
